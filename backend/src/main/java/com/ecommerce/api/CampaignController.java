package com.ecommerce.api;

import com.ecommerce.application.ICampaignService;
import com.ecommerce.domain.dto.CampaignDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("캠페인 관련 기능")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/donationBoard")
public class CampaignController {

    public static final Logger logger = LoggerFactory.getLogger(CampaignController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private ICampaignService campaignService;

    @Autowired
    public CampaignController(ICampaignService campaignService){
        this.campaignService = campaignService;
    }

    // 캠페인 등록
    @ApiOperation(value = "캠페인 등록", notes = "캠페인 등록")
    @PostMapping(value = "/createBoard")
    public ResponseEntity<?> createBoard(@ModelAttribute CampaignDto campaign) throws Exception {
        logger.info("createBoard - 호출");

        return campaignService.create(campaign);
    }

    // 캠페인 조회
    @ApiOperation(value = "캠페인 전체 조회", notes = "캠페인 전체 조회")
    @GetMapping(value = "/listBoard")
    public List<CampaignDto> listBoard() {
        logger.info("listBoard - 호출");

        return campaignService.getAllCampaign();
    }

    @ApiOperation(value = "캠페인 수정", notes = "캠페인 수정")
    @PutMapping(value = "/detailBoard/{campaign_id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateBoard(@PathVariable("campaign_id") Long campaignId, CampaignDto campaignDto){
        return campaignService.updateCampaign(campaignId,campaignDto);
    }

    @ApiOperation(value = "캠페인 삭제", notes = "캠페인 삭제")
    @DeleteMapping("/detailBoard/{campaign_id}")
    public ResponseEntity<?> deleteCampaign(@PathVariable("campaign_id") Long campaignId){
        return campaignService.deleteCampaign(campaignId);
    }
}
