package com.ecommerce.domain.repository.response;

import lombok.Data;

@Data
public class BloodCardDonationRes {
    private String transactionCardFromId;
    private String transactionCardToId;
    private String bloodCardId;
    private String transactionCardDate;
    private String transactionCardMessage;
}
