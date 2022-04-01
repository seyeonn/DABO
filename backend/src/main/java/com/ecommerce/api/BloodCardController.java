package com.ecommerce.api;

import com.ecommerce.application.impl.BloodCardService;
import com.ecommerce.domain.repository.entity.BloodCard;
import com.ecommerce.domain.repository.request.BloodCardDonationReq;
import com.ecommerce.domain.repository.request.BloodCardPostReq;
import com.ecommerce.domain.repository.response.BaseResponseBody;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/bc")
public class BloodCardController {
    @Autowired
    BloodCardService bloodCardService;

    @PostMapping("/create")
    @ApiOperation(value = "전자 헌혈증 생성", notes = "전자 헌혈증 생성")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BloodCardPostReq.class),
            @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
    public ResponseEntity<? extends BaseResponseBody> createBloodCard(@ApiIgnore Authentication authentication, @RequestBody BloodCardPostReq bloodCardPostReq){
        BloodCard bloodCard = bloodCardService.createBloodCard(bloodCardPostReq);
        if(bloodCard != null){
            return ResponseEntity.status(200).body(BaseResponseBody.of(200,"success"));
        }
        return ResponseEntity.status(500).body(BaseResponseBody.of(500,"error"));
    }

    @GetMapping("{bloodCardId}")
    @ApiOperation(value = "전자 헌혈증 조회", notes = "전자 헌혈증 조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BloodCardPostReq.class),
            @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
    public ResponseEntity<? extends BaseResponseBody> getBloodCard(@PathVariable("bloodCardId") String bloodCardId){
        return null;
    }

    @PostMapping("/donation")
    @ApiOperation(value = "전자 헌혈증 기부", notes = "전자 헌혈증 기부")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BloodCardPostReq.class),
            @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
    public ResponseEntity<? extends BaseResponseBody> bloodCardDonation(@RequestBody BloodCardDonationReq bloodCardDonationReq){
        return null;
    }

    @GetMapping("/transactionHistory/send")
    @ApiOperation(value = "전자 헌혈증 기부내역 조회", notes = "전자 헌혈증 기부내역 조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BloodCardPostReq.class),
            @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
    public ResponseEntity<? extends BaseResponseBody> bloodCardDonationSend(){
        return null;
    }

    @GetMapping("/transactionHistory/receive")
    @ApiOperation(value = "전자 헌혈증 기부받은 내역 조회", notes = "전자 헌혈증 기부받은 내역 조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BloodCardPostReq.class),
            @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
    public ResponseEntity<? extends BaseResponseBody> bloodCardDonationReceive(){
        return null;
    }

}
