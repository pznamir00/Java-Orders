package com.application.orders.mappers;

import com.application.orders.documents.Order;
import com.application.orders.mappers.entities.OrderCreationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ProductMapper.class)
public interface OrderCreationMapper {
    OrderCreationMapper INSTANCE = Mappers.getMapper(OrderCreationMapper.class);

    @Mapping(target = "title")
    @Mapping(target = "description")
    @Mapping(target = "archived")
    @Mapping(target = "products")
    Order orderCreationDTOToOrder(OrderCreationDTO order);
}
