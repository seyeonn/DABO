package com.ecommerce.application.impl;

import com.ecommerce.application.ICashContractService;
import com.ecommerce.application.IEthereumService;
import com.ecommerce.application.IWalletService;
import com.ecommerce.domain.exception.ApplicationException;
import com.ecommerce.domain.exception.NotFoundException;
import com.ecommerce.domain.repository.entity.Address;
import com.ecommerce.domain.repository.entity.Wallet;
import com.ecommerce.domain.repository.IWalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * TODO Sub PJT Ⅱ 과제 1, 과제 3
 * 과제 1: 지갑 관련 기능 구현
 * 1) 지갑 등록, 2) 지갑 조회, 3) 충전
 * 과제 3: 지갑 관련 기능 확장 구현
 * 1) 지갑 토큰 잔액 조회 추가
 *
 * IWalletService를 implements 하여 구현합니다.
 */
@Service
public class WalletService implements IWalletService
{
	private static final Logger log = LoggerFactory.getLogger(WalletService.class);

	private IWalletRepository walletRepository;
	private IEthereumService ethereumService;
	private ICashContractService cashContractService;

	@Autowired
	public WalletService(IWalletRepository walletRepository,
						 IEthereumService ethereumService,
						 ICashContractService cashContractService) {
		this.walletRepository = walletRepository;
		this.ethereumService = ethereumService;
		this.cashContractService = cashContractService;
	}

	/**
	 * 지갑 조회
	 * DB에 저장된 지갑주소의 정보와 이더리움의 잔액 정보를 동기화한다.
	 * @param walletAddress
	 * @return Wallet
	 */
	@Override
	public Wallet getAndSyncBalance(final String walletAddress)
	{
		log.debug("getAndSyncBalance Start");
		Wallet wallet = walletRepository.get(walletAddress);
		log.debug(wallet.toString());
		if(wallet == null)
			throw new NotFoundException(walletAddress + " 해당 주소 지갑을 찾을 수 없습니다.");

		// ether balance only
		/*
		BigDecimal currentBalance = new BigDecimal(this.ethereumService.getBalance(walletAddress));
		if(!wallet.getBalance().equals(currentBalance)) {
			wallet = this.syncBalance(walletAddress, currentBalance);
			wallet.setBalance(currentBalance);
		}
		*/

		// ether + cash balance
		Address address = this.ethereumService.getAddress(walletAddress);
		int cashBalance = this.cashContractService.getBalance(walletAddress);
		if(!wallet.getBalance().equals(new BigDecimal(address.getBalance())) || wallet.getCash()!= cashBalance) {
			wallet = syncBalance(walletAddress, new BigDecimal(address.getBalance()),wallet.getPayBalance(), cashBalance);
			wallet.setBalance(new BigDecimal(address.getBalance()));
			wallet.setCash(cashBalance);
		}

		return wallet;
	}

	@Override
	public Wallet get(final long userId)
	{
		Wallet wallet = this.walletRepository.get(userId);
		if(wallet == null)
			throw new NotFoundException(userId + " 해당 회원의 주소 지갑을 찾을 수 없습니다.");

		return getAndSyncBalance(wallet.getAddress());
	}

	@Override
	public Wallet register(final Wallet wallet)
	{

		long id = this.walletRepository.create(wallet);
		return this.walletRepository.get(id);
	}

	@Override
	public Wallet syncBalance(final String walletAddress, final BigDecimal balance, final BigDecimal payBalance,final int cash)
	{
		int affected = this.walletRepository.updateBalance(walletAddress, balance,payBalance, cash);
		if(affected == 0)
			throw new ApplicationException("잔액 갱신 처리가 반영되지 않았습니다.");

		return this.walletRepository.get(walletAddress);
	}

	@Override
	public Wallet updateRequestNo(final String walletAddress)
	{
		int affected = this.walletRepository.updateRequestNo(walletAddress);
		if(affected == 0)
			throw new ApplicationException("충전회수갱신 처리가 반영되지 않았습니다.");

		return this.walletRepository.get(walletAddress);
	}

	/**
	 * [지갑주소]로 이더를 송금하는 충전 기능을 구현한다.
	 * 무한정 충전을 요청할 수 없도록 조건을 두어도 좋다.
	 * @param walletAddress
	 * @return Wallet
	 */
	@Override
	public Wallet requestEth(String walletAddress) {
		Wallet wallet = this.getAndSyncBalance(walletAddress);
		if (wallet == null || !wallet.canRequestEth()) {
			throw new ApplicationException("[1] 충전할 수 없습니다!");
		}

		try {
			String txHash = this.ethereumService.requestEth(walletAddress);
			if(txHash == null || txHash.equals(""))
				throw new ApplicationException("충전 회수 갱신 트랜잭션을 보낼 수 없습니다!");
			log.info("received txhash: " + txHash);

			this.updateRequestNo(walletAddress);

			return this.getAndSyncBalance(walletAddress);
		}
		catch (Exception e) {
			throw new ApplicationException("[2] 충전할 수 없습니다!");
		}
	}

	@Override
	public List<Wallet> list()
	{
		return this.walletRepository.list();
	}
}
