package com.app.sony.repository;

import com.app.sony.entity.CartEntity;
import com.app.sony.entity.ProductEntity;
import com.app.sony.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<CartEntity, Integer> {
    Optional<CartEntity> findByProductId(Integer productId);

    @Query(value = "SELECT * FROM cart WHERE product_id = :productId", nativeQuery = true)
    Optional<CartEntity> findByProduct(Integer productId);

    @Query(value = "SELECT * FROM cart WHERE user_id = :userId", nativeQuery = true)
    List<CartEntity> findByUser(Integer userId);
}
