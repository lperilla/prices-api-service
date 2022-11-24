package com.lperilla.pocs.prices.api.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lperilla.pocs.prices.api.entity.PriceEntity;

@Repository
public interface PriceRepository extends CrudRepository<PriceEntity, Integer> {

    List<PriceEntity> findAll();

    @Query("SELECT price FROM PriceEntity price INNER JOIN price.brand brand"
            + " WHERE price.startDate <= :applicationDate AND price.endDate >= :applicationDate "
            + " AND price.productId = :productId AND brand.id = :brandId")
    Page<PriceEntity> findPrice(Integer brandId, Integer productId, OffsetDateTime applicationDate, Pageable pageable);
}
