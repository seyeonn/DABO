package com.ecommerce.domain.repository.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class TransactionDonationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name="id", example="1")
    private long id;
    private LocalDate created_at = LocalDate.now();

    //0: token 충전 /1: 기부 / 2:
    @ApiModelProperty(name="state", example="1")
    private int state;
}
