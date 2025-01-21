package com.app.sony.mapper;

import com.app.sony.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    com.app.sony.entity.ProductEntity productToProductEntity(com.app.sony.model.Product product);

    com.app.sony.model.Product productEntityToProduct(com.app.sony.entity.ProductEntity productEntity);

    List<Product> productEntityListToProductList(List<com.app.sony.entity.ProductEntity> productEntityList);
}
