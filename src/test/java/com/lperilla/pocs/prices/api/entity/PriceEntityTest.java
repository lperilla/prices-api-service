package com.lperilla.pocs.prices.api.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PriceEntityTest {

	static PriceEntity entity;

	@BeforeAll
	static void setup() {
		entity = PriceEntity.builder().startDate(OffsetDateTime.of(2022, 6, 14, 15, 0, 0, 0, ZoneOffset.UTC))
				.endDate(OffsetDateTime.of(2022, 12, 31, 23, 59, 59, 0, ZoneOffset.UTC)).pricesList(1).productId(35455).priority(1)
				.price(25.45).currency("EUR").build();
	}

	@Test
	final void testStartDate() {
		assertNotNull(entity.getStartDate());
		assertEquals(OffsetDateTime.of(2022, 6, 14, 15, 0, 0, 0, ZoneOffset.UTC), entity.getStartDate());
		entity.setStartDate(OffsetDateTime.of(2022, 12, 31, 23, 59, 59, 0, ZoneOffset.UTC));
		assertEquals(OffsetDateTime.of(2022, 12, 31, 23, 59, 59, 0, ZoneOffset.UTC), entity.getStartDate());
	}

	@Test
	final void testEndDate() {
		assertNotNull(entity.getEndDate());
		assertEquals(OffsetDateTime.of(2022, 12, 31, 23, 59, 59, 0, ZoneOffset.UTC), entity.getEndDate());
		entity.setEndDate(OffsetDateTime.of(2023, 12, 31, 23, 59, 59, 0, ZoneOffset.UTC));
		assertEquals(OffsetDateTime.of(2023, 12, 31, 23, 59, 59, 0, ZoneOffset.UTC), entity.getEndDate());
	}

	@Test
	final void testPricesList() {
		assertNotNull(entity.getPricesList());
		assertEquals(1, entity.getPricesList());
		entity.setPricesList(2);
		assertEquals(2, entity.getPricesList());
	}

	@Test
	final void testProductId() {
		assertNotNull(entity.getProductId());
		assertEquals(35455, entity.getProductId());
		entity.setProductId(35456);
		assertEquals(35456, entity.getProductId());
	}

	@Test
	final void testPriority() {
		assertNotNull(entity.getPriority());
		assertEquals(1, entity.getPriority());
		entity.setPriority(0);
		assertEquals(0, entity.getPriority());
	}

	@Test
	final void testPrice() {
		assertNotNull(entity.getPrice());
		assertEquals(25.45, entity.getPrice());
		entity.setPrice(25.46);
		assertEquals(25.46, entity.getPrice());
	}

	@Test
	final void testCurr() {
		assertNotNull(entity.getCurrency());
		assertEquals("EUR", entity.getCurrency());
		entity.setCurrency("USD");
		assertEquals("USD", entity.getCurrency());
	}

	@Test
	final void testPricesEntity() {
		assertNotNull(entity);
	}

}
