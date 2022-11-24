package com.lperilla.pocs.prices.api.service;

import java.time.OffsetDateTime;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lperilla.pocs.prices.api.mapper.PriceMapper;
import com.lperilla.pocs.prices.api.model.Price;
import com.lperilla.pocs.prices.api.repository.PriceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService{

    private PriceMapper mapper;

    private PriceRepository repository;

    @Override
    public Price findPrice(Integer brandId, Integer productId, OffsetDateTime applicationDate) {
        return mapper.entityToDto(repository.findPrice(brandId, productId, applicationDate, PageRequest.of(0, 1, Direction.DESC, "priority")).get().findFirst().orElseThrow());
    }

}
