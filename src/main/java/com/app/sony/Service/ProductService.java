package com.app.sony.Service;

import com.app.sony.entity.ProductEntity;
import com.app.sony.mapper.ProductMapper;
import com.app.sony.model.Product;
import com.app.sony.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public ResponseEntity<List<Product>> getAllProducts() {

        try {
            List<ProductEntity> productEntityList = productRepository.findAll();
            List<Product> productList = productMapper.productEntityListToProductList(productEntityList);
            if (productEntityList.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(productList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResponseEntity<Product> getProductById(Integer id) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
        if(productEntityOptional.isPresent()) {
            ProductEntity productEntity = productEntityOptional.get();
            Product product = productMapper.productEntityToProduct(productEntity);
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
