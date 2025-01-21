package com.app.sony.Service;

import com.app.sony.entity.CategoryEntity;
import com.app.sony.mapper.CategoryMapper;
import com.app.sony.model.Category;
import com.app.sony.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return categoryMapper.categoryEntityListtoCategoryList(categoryEntities);


    }
}
