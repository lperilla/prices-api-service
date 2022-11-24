package com.lperilla.pocs.prices.api.controller;

import java.time.OffsetDateTime;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.lperilla.pocs.prices.api.model.Price;
import com.lperilla.pocs.prices.api.service.PriceService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PricesApiImpl implements PricesApi {

	private PriceService priceService;
	
	@Override
	public ResponseEntity<Price> findPrices(Integer brandId, Integer productId, @Valid OffsetDateTime applicationDate) {
		return ResponseEntity.ok(priceService.findPrice(brandId, productId, applicationDate));
	}

}
