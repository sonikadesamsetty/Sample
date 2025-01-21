package com.app.sony.mapper;

import com.app.sony.entity.CategoryEntity;
import com.app.sony.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryEntity categorytoCategoryEntity(Category category);
    Category categoryEntitytoCategory(CategoryEntity categoryEntity);

    List<Category> categoryEntityListtoCategoryList(List<CategoryEntity> categoryEntityList);
}
