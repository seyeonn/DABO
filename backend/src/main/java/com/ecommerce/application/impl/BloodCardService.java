package com.ecommerce.application.impl;

import com.ecommerce.application.IBloodCardService;
import com.ecommerce.domain.repository.entity.BloodCard;
import com.ecommerce.domain.repository.request.BloodCardDonationReq;
import com.ecommerce.domain.repository.request.BloodCardPostReq;
import com.ecommerce.domain.repository.response.BloodCardDonationRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodCardService implements IBloodCardService {

    @Override
    public BloodCard createBloodCard(BloodCardPostReq bloodCardPostReq) {
        BloodCard bloodCard = new BloodCard();
        bloodCard.setBloodCardId(bloodCard.getBloodCardId());
        //bloodCard.setUserId();
        return null;
    }

    @Override
    public List<BloodCard> getBloodCard(String bloodCardId) {
        return null;
    }

    @Override
    public BloodCardDonationRes bloodCardDonation(BloodCardDonationReq bloodCardDonationReq) {
        return null;
    }

    @Override
    public BloodCardDonationRes bloodCardDonationSend() {
        return null;
    }

    @Override
    public BloodCardDonationRes bloodCardDonationReceive() {
        return null;
    }
}
