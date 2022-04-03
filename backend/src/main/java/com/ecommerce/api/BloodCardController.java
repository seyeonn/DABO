package com.ecommerce.api;

import com.ecommerce.application.impl.BloodCardService;
import com.ecommerce.domain.dto.BloodCardDto;
import com.ecommerce.domain.repository.entity.BloodCard;
import com.ecommerce.domain.repository.entity.DABOUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blood_card")
public class BloodCardController {

    BloodCardService bloodCardService;

    @Autowired
    public BloodCardController(BloodCardService bloodCardService) {
        this.bloodCardService = bloodCardService;
    }

    // 헌혈증 등록
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public BloodCard register(@RequestBody BloodCardDto bloodCardDto){
        BloodCard bloodCard = bloodCardService.register(bloodCardDto);
        return bloodCard;
    }

}
