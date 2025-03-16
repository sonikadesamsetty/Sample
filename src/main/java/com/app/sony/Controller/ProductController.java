package com.app.sony.Controller;

import com.app.sony.Service.ProductService;
import com.app.sony.api.ProductsApi;
import com.app.sony.model.Product;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class ProductController implements ProductsApi {

    @Autowired
    private ProductService productService;


    @Override
    public ResponseEntity<List<Product>> productsGet() {
        return productService.getAllProducts();
    }

    @Override
    public ResponseEntity<Product> productsIdGet(Integer id) {
        return productService.getProductById(id);
    }

}
