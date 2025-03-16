package com.app.sony.Service;

import com.app.sony.entity.CartEntity;
import com.app.sony.entity.ProductEntity;
import com.app.sony.entity.UserEntity;
import com.app.sony.model.Cart;
import com.app.sony.model.Product;
import com.app.sony.repository.CartRepository;
import com.app.sony.repository.ProductRepository;
import com.app.sony.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository  cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepo  userRepo;

    public String addToCart(Product prod, String userId) {
        Optional<ProductEntity> product = productRepository.findById(prod.getId());
        UserEntity user = userRepo.findByEmail(userId);
        if(product.isPresent())
        {
            Optional<CartEntity> cartEntity = cartRepository.findByProduct(prod.getId());
            if(cartEntity.isPresent()){
                cartEntity.get().setQuantity(cartEntity.get().getQuantity() + 1);
                cartRepository.save(cartEntity.get());
            }
            else{
                CartEntity cart = new CartEntity();
                cart.setProduct(product.get());
                cart.setQuantity(1);
                cart.setUser(user);
                cartRepository.save(cart);
            }
            return "Product added to cart";
        }
        return "Product not found";
    }

   /* public void removeFromCart(Integer productId, Integer userId) {
        cartRepository.removeFromCart(productId, userId);
    }

    public void clearCart(Integer userId) {
        cartRepository.clearCart(userId);
    }

    public void updateCart(Integer productId, Integer userId, Integer quantity) {
        cartRepository.updateCart(productId, userId, quantity);
    }*/
    public List<Cart> getCart(String userId) {
        UserEntity userEntity = userRepo.findByEmail(userId);
        List<CartEntity> cartList = cartRepository.findByUser(userEntity.getUserId());
        List<Cart> cart = new ArrayList<>();
        cartList.forEach(c->{
            Product product = new Product();
            product.setId(c.getProduct().getId());
            product.setName(c.getProduct().getName());
            product.setPrice(c.getProduct().getPrice());
            product.setImageUrl(c.getProduct().getImageUrl());
            product.setDescription(c.getProduct().getDescription());
            product.setQuantity(c.getQuantity());
            Cart cart1 = new Cart(c.getId(), c.getUser().getUserId(), product, c.getQuantity());
            cart.add(cart1);
        });
        return cart;
    }
}
