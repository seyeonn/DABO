package com.ecommerce.domain.repository.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Wallets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String address;
    long ownerId;
    long balance;
    long payBalance;
    int receivingCount;
    long cash;
}
