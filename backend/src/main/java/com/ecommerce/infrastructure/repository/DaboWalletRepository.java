package com.ecommerce.infrastructure.repository;

import com.ecommerce.domain.repository.entity.Wallet;
import com.ecommerce.domain.repository.entity.Wallets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface DaboWalletRepository extends JpaRepository<Wallets, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE wallets SET cash = cash + :amount where address = :transactionDonationToAddress ", nativeQuery = true)
    void daboSend(@Param("transactionDonationToAddress") String transactionDonationToAddress, @Param("amount") long amount);

    @Transactional
    @Modifying
    @Query(value = "UPDATE wallets SET cash = cash - :amount where address = :transactionDonationToAddress ", nativeQuery = true)
    void daboReceive(@Param("transactionDonationToAddress")String transactionDonationFromAddress, @Param("amount")long amount);
}
