package com.ecommerce.domain.repository.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BloodCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bloodCard_id")
    Long bloodCardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private DABOUser user;

    private String userName;

    private String userBirth;

    private String donationDate;

    private String donationType;

    private String bloodHouse;

    private String userGender;

    private String bloodCardNumber;

}
