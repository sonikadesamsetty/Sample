package com.app.sony.Controller;

import com.app.sony.Service.CartService;
import com.app.sony.api.CartApi;
import com.app.sony.model.Cart;
import com.app.sony.model.Product;
import com.app.sony.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class CartController {

    @Autowired
    CartService  cartService;

    @RequestMapping(path = "/addToCart",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateCart(@RequestBody Product product,@RequestParam("userEmail") String userEmail) {
        System.out.println(product);
        return cartService.addToCart(product, userEmail);
    }

    @RequestMapping(path = "/cart",method = RequestMethod.GET)
    public ResponseEntity<List<Cart>> getCart(@RequestParam("userEmail") String userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }
}