package com.application.orders.mappers;

import com.application.orders.documents.Product;
import com.application.orders.mappers.entities.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductMapper {

    @Mapping(target="name")
    @Mapping(target="url")
    @Mapping(target="price")
    Product productDTOToProduct(ProductDTO productDTO);

    ProductDTO productToProductDTO(Product product);
}
