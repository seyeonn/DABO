package com.ecommerce.domain.dto;

import com.ecommerce.domain.repository.entity.DABOUser;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BloodCardDto {

    private String userName;

    private String userBirth;

    private String donationDate;

    private String donationType;

    private String bloodHouse;

    private String userGender;

    private String bloodCardNumber;
}
