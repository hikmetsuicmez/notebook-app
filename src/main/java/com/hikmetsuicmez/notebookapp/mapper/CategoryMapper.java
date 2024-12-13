package com.hikmetsuicmez.notebookapp.mapper;

import com.hikmetsuicmez.notebookapp.dto.request.CategoryRequest;
import com.hikmetsuicmez.notebookapp.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

        CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

        Category toEntity(CategoryRequest categoryRequest);
        Category toResponse(Category category);
}
