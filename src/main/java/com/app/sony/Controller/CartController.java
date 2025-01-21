package com.app.sony.Controller;

import com.app.sony.api.CartApi;
import com.app.sony.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CartController implements CartApi {
    @Override
    public ResponseEntity<List<Product>> cartGet() {
        return null;
    }

    @Override
    public ResponseEntity<Product> cartPost(Long id) {
        return null;
    }
}
