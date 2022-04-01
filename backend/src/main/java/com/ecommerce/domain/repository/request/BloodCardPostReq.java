package com.ecommerce.domain.repository.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BloodCardPostReq {
    private String bloodCardNumber;
    private String userName;
    private LocalDateTime userBirth;
    private LocalDateTime donationDate;
    private String donationType;
    private String bloodHouse;
    private String userGender;
}
