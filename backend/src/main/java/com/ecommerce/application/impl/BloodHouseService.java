package com.ecommerce.application.impl;

import com.ecommerce.domain.dto.BloodHouseDto;
import com.ecommerce.domain.dto.CampaignDto;
import com.ecommerce.domain.dto.CommentDto;
import com.ecommerce.domain.dto.ReservationDto;
import com.ecommerce.domain.repository.BloodHouseRepository;
import com.ecommerce.domain.repository.ReservationRepository;
import com.ecommerce.domain.repository.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BloodHouseService {

    private final BloodHouseRepository bloodHouseRepository;
    private final ReservationRepository reservationRepository;

    // 헌혈의 집 전체 목록 조회
    @Transactional
    public List<BloodHouseDto> getAllBloodHouse() {
        System.out.println("hi");
        System.out.println("왜 또 안뜸?");
        List<BloodHouseDto> list = new ArrayList<>();

        for(BloodHouse bloodHouse : bloodHouseRepository.findAll()) {

            BloodHouseDto bloodHouseDto = new BloodHouseDto();

            bloodHouseDto.setBloodHouseId(bloodHouse.getBloodHouseId());
            bloodHouseDto.setNet(bloodHouse.getNet());
            bloodHouseDto.setHousename(bloodHouse.getHousename());
            bloodHouseDto.setAddress(bloodHouse.getAddress());
            bloodHouseDto.setTelephone(bloodHouse.getTelephone());

            list.add(bloodHouseDto);
        }
        return list;
    }

    // 헌혈의 집 상세 조회
    @Transactional
    public BloodHouseDto getBloodHouse(Long bloodHouseId) {

        Optional<BloodHouse> optBloodHouse = bloodHouseRepository.findById(bloodHouseId);
        if(!optBloodHouse.isPresent()) {
            return null;
        }
        BloodHouse bloodHouse = optBloodHouse.get();

        BloodHouseDto bloodHouseDto = new BloodHouseDto();
        bloodHouseDto.setBloodHouseId(bloodHouse.getBloodHouseId());
        bloodHouseDto.setHousename(bloodHouse.getHousename());
        bloodHouseDto.setAddress(bloodHouse.getAddress());
        bloodHouseDto.setTelephone(bloodHouse.getTelephone());

        return bloodHouseDto;
    }

    // 헌혈의 집 검색 - 주소 기준
    @Transactional
    public List<BloodHouseDto> searchBloodHouse(String keyword) {
        List<BloodHouse> bloodHouses = bloodHouseRepository.findByAddressContaining(keyword);
        List<BloodHouseDto> bloodHouseDtoList = new ArrayList<>();

        if(bloodHouses.isEmpty())
            return bloodHouseDtoList;

        for(BloodHouse bloodHouse : bloodHouses) {

            BloodHouseDto bloodHouseDto = new BloodHouseDto();

            bloodHouseDto.setBloodHouseId(bloodHouse.getBloodHouseId());
            bloodHouseDto.setNet(bloodHouse.getNet());
            bloodHouseDto.setHousename(bloodHouse.getHousename());
            bloodHouseDto.setAddress(bloodHouse.getAddress());
            bloodHouseDto.setTelephone(bloodHouse.getTelephone());

            bloodHouseDtoList.add(bloodHouseDto);
        }
        return bloodHouseDtoList;
    }

    // 헌혈의 집 예약
    @Transactional
    public ResponseEntity<?> reservation(ReservationDto reservationDto) {

        Reservation reservation = Reservation.builder()
                .housename(reservationDto.getHousename())
                .address(reservationDto.getAddress())
                .telephone(reservationDto.getTelephone())
                .bloodDate(reservationDto.getBloodDate())
                .bloodTime(reservationDto.getBloodTime())
                .bloodType(reservationDto.getBloodType())
                .build();

        System.out.println(reservation);
        reservationRepository.save(reservation);

        System.out.println(reservation.getReservationId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 예약 내역 조회
    @Transactional
    public ReservationDto getReservation(Long reservationId) {

        Optional<Reservation> optReservation = reservationRepository.findById(reservationId);
        if(!optReservation.isPresent()) {
            return null;
        }
        Reservation reservation = optReservation.get();

        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setReservationId(reservation.getReservationId());
        reservationDto.setHousename(reservation.getHousename());
        reservationDto.setAddress(reservation.getAddress());
        reservationDto.setTelephone(reservation.getTelephone());
        reservationDto.setBloodDate(reservation.getBloodDate());
        reservationDto.setBloodTime(reservation.getBloodTime());
        reservationDto.setBloodType(reservation.getBloodType());

        return reservationDto;
    }
}
