package com.ecommerce.application;

import com.ecommerce.domain.repository.entity.BloodCard;
import com.ecommerce.domain.repository.request.BloodCardDonationReq;
import com.ecommerce.domain.repository.request.BloodCardPostReq;
import com.ecommerce.domain.repository.response.BloodCardDonationRes;

import java.util.List;

public interface IBloodCardService {
    BloodCard createBloodCard(BloodCardPostReq bloodCardPostReq);
    List<BloodCard> getBloodCard(String bloodCardId);
    BloodCardDonationRes bloodCardDonation(BloodCardDonationReq bloodCardDonationReq);
    BloodCardDonationRes bloodCardDonationSend();
    BloodCardDonationRes bloodCardDonationReceive();

}
