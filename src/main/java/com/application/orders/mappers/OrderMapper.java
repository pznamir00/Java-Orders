package com.application.orders.mappers;

import com.application.orders.documents.Order;
import com.application.orders.mappers.entities.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "id")
    @Mapping(target = "title")
    @Mapping(target = "description")
    @Mapping(target = "status")
    @Mapping(target = "createdAt")
    @Mapping(target = "updatedAt")
    Order orderDTOToOrder(OrderDTO order);

    @Mapping(target = "id")
    @Mapping(target = "title")
    @Mapping(target = "description")
    @Mapping(target = "status")
    @Mapping(target = "createdAt")
    @Mapping(target = "updatedAt")
    OrderDTO orderToOrderDTO(Order order);
}
