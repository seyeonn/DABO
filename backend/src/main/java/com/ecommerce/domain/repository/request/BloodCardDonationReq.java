package com.ecommerce.domain.repository.request;

import lombok.Data;

@Data
public class BloodCardDonationReq {
    private String transactionCardFromId;
    private String transactionCardToId;
    private String bloodCardId;
    private String transactionCardDate;
    private String transactionCardMessage;
}
