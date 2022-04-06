package com.ecommerce.domain.dto;

import io.swagger.annotations.ApiParam;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BloodHouseDto {

    private Long bloodHouseId;

    @ApiParam(value="혈액원")
    private String net;

    @ApiParam(value="헌혈의 집")
    private String housename;

    @ApiParam(value="주소")
    private String address;

    @ApiParam(value="전화번호")
    private String telephone;
}
