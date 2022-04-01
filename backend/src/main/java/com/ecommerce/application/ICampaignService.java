package com.ecommerce.application;

import com.ecommerce.domain.dto.CampaignDto;
import com.ecommerce.domain.dto.CommentDto;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface ICampaignService {
    ResponseEntity<?> create(CampaignDto campaign) throws IOException;
    List<CampaignDto> getAllCampaign();
    ResponseEntity<?> updateCampaign(Long campaignId, CampaignDto campaignDto);
    ResponseEntity<?> deleteCampaign(Long campaignId);
    ResponseEntity<?> postComment(Long campaignId, CommentDto commentDto);
    List<CommentDto> getComments(Long campaignId);
    ResponseEntity<?> updateComment(Long commentId, CommentDto commentDto);
    ResponseEntity<?> deleteComment(Long commentId);
}
