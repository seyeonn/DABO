package com.ecommerce.domain.wrapper;

import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * TODO
 * Sub PJT Ⅲ 추가과제
 * 이더리움 트랜잭션을 위한 데이터 클래스
 */
@Data
public class EthereumTransaction {

    private String txHash;
    private String Status;
    private String blockId;
    private LocalDateTime timestamp;
    private String from;
    private String to;
    private BigInteger amount;
    private boolean accepted;

    public static EthereumTransaction convertTransaction(final com.ecommerce.domain.Transaction transaction)
    {
        EthereumTransaction tx = new EthereumTransaction();
        tx.txHash = transaction.getHash();
        tx.blockId = transaction.getBlockNumber();
        tx.from = transaction.getFrom();
        tx.to = transaction.getTo();
        if(transaction.getValue() != null)
            tx.amount = new BigInteger(transaction.getValue());

        return tx;
    }
}
