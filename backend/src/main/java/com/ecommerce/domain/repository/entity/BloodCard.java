package com.ecommerce.domain.repository.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class BloodCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bloodCardId;

    private long userId;
    private String bloodCardNumber;
    private String userName;
    private LocalDateTime userBirth;
    private LocalDateTime donationDate;
    private String donationType;
    private String bloodHouse;
    private String userGender;
}
