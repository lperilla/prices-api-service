package com.lperilla.pocs.prices.api.service;

import java.time.OffsetDateTime;

import com.lperilla.pocs.prices.api.model.Price;

public interface PriceService {

    Price findPrice(Integer brandId, Integer productId, OffsetDateTime applicationDate);
}
