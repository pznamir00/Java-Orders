package com.application.orders.mappers;

import com.application.orders.documents.Order;
import com.application.orders.mappers.entities.OrderSimplifiedDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderSimplifiedMapper {
    OrderSimplifiedMapper INSTANCE = Mappers.getMapper(OrderSimplifiedMapper.class);

    @Mapping(target = "id")
    @Mapping(target = "title")
    @Mapping(target = "description")
    @Mapping(target = "status")
    OrderSimplifiedDTO orderToOrderDTO(Order order);
}
