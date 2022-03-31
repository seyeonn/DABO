package com.ecommerce.application.impl;

import com.ecommerce.application.ICampaignService;
import com.ecommerce.config.auth.PrincipalDetails;
import com.ecommerce.config.media.GlobalConfig;
import com.ecommerce.domain.dto.CampaignDto;
import com.ecommerce.domain.repository.ICampaignRepository;
import com.ecommerce.domain.repository.entity.Campaign;
import com.ecommerce.domain.repository.entity.DABOUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CampaignService implements ICampaignService {

    private final ICampaignRepository campaignRepository;
    private final GlobalConfig config;

    @Transactional
    @Override
    public ResponseEntity<?> create(CampaignDto campaign) {

        MultipartFile multipartFile = campaign.getMedia();

        // 파일 없음 || 파일이 비어있음
        if(multipartFile == null || multipartFile.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // 현재 날짜 폴더만들어서 저장
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String uploadFilePath = config.getUploadFilePath()+currentDate+"/";

        // 랜덤이름 + . 확장자 가져오기
        String postfix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1, multipartFile.getOriginalFilename().length());
        String filename = UUID.randomUUID().toString() + "." + postfix;

        // 폴더 없으면 만들기
        File folder = new File(uploadFilePath);
        if(!folder.isDirectory()){
            folder.mkdirs();
        }

        String pathname = uploadFilePath+filename;
        String resourcePathname = config.getUploadResourcePath()+currentDate+"/"+filename;

        // url 경로 출력
        System.out.println("resourcePathname = " + resourcePathname);

        // 새로 파일 만들기
        File dest = new File(pathname);
        System.out.println(dest);
        try {
            multipartFile.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get User
//        PrincipalDetails principalDetails = (PrincipalDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        DABOUser userTemp = principalDetails.getUser();
        //DABOUser user = DABOUserRepository.findByEmail(userTemp.getEmail());

        Campaign newCampaign = Campaign.builder()
                        //.user(user)
                        .title(campaign.getTitle())
                        .content(campaign.getContent())
                        .target(campaign.getTarget())
                        .amount(campaign.getAmount())
                        .deadLine(campaign.getDeadLine())
                        .build();
        campaignRepository.save(newCampaign);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    public List<CampaignDto> getAllCampaign() {

        List<CampaignDto> list = new ArrayList<>();

        for(Campaign campaign : campaignRepository.findAll()) {

            CampaignDto campaignDto = new CampaignDto();

            campaignDto.setCampaignId(campaign.getCampaignId());
            campaignDto.setTitle(campaign.getTitle());
            campaignDto.setContent(campaign.getContent());
            campaignDto.setTarget(campaign.getTarget());
            campaignDto.setAmount(campaign.getAmount());
            campaignDto.setDeadLine(campaign.getDeadLine());
            campaignDto.setMediaUrl(campaign.getMediaUrl());
            //campaignDto.setUsername(campaign.getUser().getNickname());

            list.add(campaignDto);
        }

        return list;
    }

    @Transactional
    public ResponseEntity<?> updateCampaign(Long campaignId, CampaignDto campaignDto) {

        Optional<Campaign> optCampaign = campaignRepository.findById(campaignId);

        if(!optCampaign.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Campaign campaign = optCampaign.get();
        campaign.setTitle(campaignDto.getTitle());
        campaign.setContent(campaignDto.getContent());
        campaign.setTarget(campaignDto.getTarget());
        campaign.setAmount(campaignDto.getAmount());
        campaign.setDeadLine(campaignDto.getDeadLine());
        campaign.setMediaUrl(campaignDto.getMediaUrl());

        campaignRepository.save(campaign);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> deleteCampaign(Long campaignId) {

        Optional<Campaign> optCampaign = campaignRepository.findById(campaignId);

        if(!optCampaign.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            campaignRepository.delete(optCampaign.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
