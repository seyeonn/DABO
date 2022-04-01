package com.ecommerce.application;

import com.ecommerce.domain.repository.entity.Wallet;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface IWalletService
{
	Wallet getAndSyncBalance(String walletAddress);
	Wallet get(long userId);

	@Transactional
	Wallet register(Wallet wallet);

	@Transactional
	Wallet syncBalance(String walletAddress, BigDecimal balance, int cash);

	@Transactional
	Wallet updateRequestNo(final String walletAddress);

	@Transactional
	Wallet requestEth(String walletAddress);

	List<Wallet> list();
}
