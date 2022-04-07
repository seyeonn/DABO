package com.ecommerce.domain.dto;

import io.swagger.annotations.ApiParam;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {

    private Long reservationId;

    @ApiParam(value="헌혈의 집")
    private String housename;

    @ApiParam(value="주소")
    private String address;

    @ApiParam(value="전화번호")
    private String telephone;

    @ApiParam(value="예약날짜")
    private String bloodDate;

    @ApiParam(value="예약 시간")
    private String bloodTime;

    @ApiParam(value="예약 타입")
    private String bloodType;

}
