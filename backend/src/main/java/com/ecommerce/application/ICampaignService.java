package com.ecommerce.application;

import com.ecommerce.domain.dto.CampaignDto;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface ICampaignService {
    ResponseEntity<?> create(CampaignDto campaign) throws IOException;
    List<CampaignDto> getAllCampaign();
    ResponseEntity<?> updateCampaign(Long campaignId, CampaignDto campaignDto);
    ResponseEntity<?> deleteCampaign(Long campaignId);
}
