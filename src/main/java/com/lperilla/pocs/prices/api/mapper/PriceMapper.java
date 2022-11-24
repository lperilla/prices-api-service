package com.lperilla.pocs.prices.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lperilla.pocs.prices.api.entity.PriceEntity;
import com.lperilla.pocs.prices.api.model.Price;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(target = "brandId", source = "entity.brand.id")
    Price entityToDto(PriceEntity entity);

    default List<Price> mapListToDto(final List<PriceEntity> entityList) {
        return entityList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

}
