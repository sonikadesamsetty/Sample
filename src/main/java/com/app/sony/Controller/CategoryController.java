package com.app.sony.Controller;

import com.app.sony.Service.CategoryService;
import com.app.sony.api.CategoriesApi;
import com.app.sony.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class CategoryController implements CategoriesApi {

    @Autowired
    CategoryService categoryService;
    @Override
    public ResponseEntity<List<Category>> categoriesGet() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
