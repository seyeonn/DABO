package com.ecommerce.api;

import com.ecommerce.application.ICampaignService;
import com.ecommerce.application.impl.BloodHouseService;
import com.ecommerce.domain.dto.BloodHouseDto;
import com.ecommerce.domain.dto.CampaignDto;
import com.ecommerce.domain.dto.CommentDto;
import com.ecommerce.domain.dto.ReservationDto;
import com.ecommerce.domain.repository.BloodHouseRepository;
import com.ecommerce.domain.repository.ICampaignRepository;
import com.ecommerce.domain.repository.entity.BloodHouse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("헌혈의 집 관련 기능")
@RestController
@RequestMapping("/api/reservation")
public class BloodHouseController {

    public static final Logger logger = LoggerFactory.getLogger(CampaignController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private BloodHouseService bloodHouseService;

    @Autowired
    public BloodHouseController(BloodHouseService bloodHouseService){
        this.bloodHouseService = bloodHouseService;
    }


    // 헌혈의 집 조회
    @ApiOperation(value = "헌혈의 집 전체 조회", notes = "헌혈의 집 전체 조회")
    @GetMapping(value = "/bloodHouseList")
    public List<BloodHouseDto> bloodHouseList() {
        logger.info("bloodHouseList - 호출");
        
        return bloodHouseService.getAllBloodHouse();
    }

    // 헌혈의 집 상세 조회
    @ApiOperation(value = "헌혈의 집 상세 조회", notes = "헌혈의 집 상세 조회")
    @GetMapping(value = "/nowReservation/{bloodhouse_id}")
    public BloodHouseDto getBloodHouse(@PathVariable("bloodhouse_id") Long bloodHouseId) {
        logger.info("getBloodHouse - 호출");

        return bloodHouseService.getBloodHouse(bloodHouseId);
    }

    // 캠페인 검색
    @ApiOperation(value = "헌혈의 집 검색", notes = "헌혈의 집 검색")
    @GetMapping("/search")
    public List<BloodHouseDto> searchCampaign(@RequestParam("keyword") String keyword){
        return bloodHouseService.searchBloodHouse(keyword);
    }

    // 예약 등록
    @ApiOperation(value = "헌혈의 집 에약", notes = "헌혈의 집 에약")
    @PostMapping("/reservationBloodHouse")
    public ResponseEntity<?> reservation(@RequestBody ReservationDto reservationDto) {
        logger.info("reservation - 호출");
        return bloodHouseService.reservation(reservationDto);
    }

    // 예약 내역 조회
    @ApiOperation(value = "헌혈의 집 에약 내역 조회", notes = "헌혈의 집 에약 내역 조회")
    @GetMapping("/reservationBloodHouse")
    public ReservationDto getReservation(Long reservationId) {
        logger.info("getReservation - 호출");
        return bloodHouseService.getReservation(reservationId);
    }
}
