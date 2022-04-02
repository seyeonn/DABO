package com.ecommerce.domain.repository.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Wallet {
	private long id;
	private long ownerId;
	private String address;
	private BigDecimal balance = BigDecimal.valueOf(0); // Eth balance
	private BigDecimal payBalance = BigDecimal.valueOf(0); // Payment Service Balance
	private int receivingCount = 0;
	private int cash = 0; //dabo Token

	public boolean canRequestEth(){
		return this.receivingCount < 10;
	}
}
