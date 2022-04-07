package com.ecommerce.domain.repository;

import com.ecommerce.domain.repository.entity.BloodHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodHouseRepository  extends JpaRepository<BloodHouse, Long> {

    List<BloodHouse> findByAddressContaining(String keyword);
    List<BloodHouse> findByHousenameContaining(String keyword);

}
