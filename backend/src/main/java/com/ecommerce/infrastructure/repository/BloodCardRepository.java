package com.ecommerce.infrastructure.repository;

import com.ecommerce.domain.repository.entity.BloodCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodCardRepository extends JpaRepository<BloodCard, Long> {
}
