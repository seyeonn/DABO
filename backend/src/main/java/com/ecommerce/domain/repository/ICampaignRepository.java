package com.ecommerce.domain.repository;

import com.ecommerce.domain.repository.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICampaignRepository  extends JpaRepository<Campaign, Long> {
}
