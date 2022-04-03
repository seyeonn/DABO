package com.ecommerce.application.impl;

import com.ecommerce.domain.dto.BloodCardDto;
import com.ecommerce.domain.exception.ApplicationException;
import com.ecommerce.domain.repository.entity.BloodCard;
import com.ecommerce.domain.repository.entity.DABOUser;
import com.ecommerce.infrastructure.repository.BloodCardRepository;
import com.ecommerce.infrastructure.repository.DABOUserRepository;
import org.apache.http.auth.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BloodCardService {

    BloodCardRepository bloodCardRepository;
    CommonService commonService;
    DABOUserRepository userRepository;

    @Autowired
    public BloodCardService(BloodCardRepository bloodCardRepository, CommonService commonService, DABOUserRepository userRepository) {
        this.bloodCardRepository = bloodCardRepository;
        this.commonService = commonService;
        this.userRepository = userRepository;
    }

    @Transactional
    public BloodCard register(BloodCardDto bloodCardDto) {
        DABOUser userTemp = commonService.getLoginUser();
        Optional<DABOUser> userOp = userRepository.findDABOUserByEmail(userTemp.getEmail());
        if(userOp.isPresent()){
            DABOUser user = userOp.get();
            BloodCard bloodCard = BloodCard.builder()
                    .user(user)
                    .userName(bloodCardDto.getUserName())
                    .userBirth(bloodCardDto.getUserBirth())
                    .userGender(bloodCardDto.getUserGender())
                    .bloodCardNumber(bloodCardDto.getBloodCardNumber())
                    .donationDate(bloodCardDto.getDonationDate())
                    .bloodHouse(bloodCardDto.getBloodHouse())
                    .donationType(bloodCardDto.getDonationType())
                    .build();
            bloodCardRepository.save(bloodCard);
            return bloodCard;
        }
        throw new ApplicationException("회원 정보를 찾을 수 없습니다.");
    }
}
