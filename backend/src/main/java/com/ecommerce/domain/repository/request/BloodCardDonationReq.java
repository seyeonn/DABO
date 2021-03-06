package com.ecommerce.domain.repository.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BloodCardDonationReq {
    private long transactionCardToId;
    private long bloodCardId;
    private long campaignId;
    private String userName;
    private String transactionCardMessage;
}
