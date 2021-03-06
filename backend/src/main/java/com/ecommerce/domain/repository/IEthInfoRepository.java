package com.ecommerce.domain.repository;

import com.ecommerce.domain.repository.entity.EthInfo;
import org.springframework.transaction.annotation.Transactional;

public interface IEthInfoRepository {
    EthInfo get(String ethUrl);

    @Transactional
    void put(String ethUrl, String blockNumber);
}
