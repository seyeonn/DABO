package com.ecommerce.domain.repository.entity;


import lombok.Data;



@Data
public class BloodStatus {
    private long daySum;
    private long dayO;
    private long dayA;
    private long dayB;
    private long dayAB;
    private long cuSum;
    private long cuO;
    private long cuA;
    private long cuB;
    private long cuAB;

    private long getStatusO(long dayO, long cuO){
        return cuO/dayO;
    }
    private long getStatusA(long dayA, long cuA){
        return cuA/dayA;
    }
    private long getStatusB(long dayB, long cuB){
        return cuB/dayB;
    }
    private long getStatusAB(long dayAB, long cuAB){
        return cuAB/dayAB;
    }



}
