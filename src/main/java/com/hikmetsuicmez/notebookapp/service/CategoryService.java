package com.hikmetsuicmez.notebookapp.service;

import com.hikmetsuicmez.notebookapp.dto.request.CategoryRequest;
import com.hikmetsuicmez.notebookapp.dto.response.CategoryResponse;
import com.hikmetsuicmez.notebookapp.mapper.CategoryMapper;
import com.hikmetsuicmez.notebookapp.model.Category;
import com.hikmetsuicmez.notebookapp.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

        private final CategoryRepository categoryRepository;
        private final CategoryMapper categoryMapper;

        public List<CategoryResponse> retrieveAllCategories() {
                List<Category> categories = categoryRepository.findAll();
                return categories
                            .stream()
                            .map(categoryMapper::toResponse)
                            .toList();
        }

        public CategoryResponse retrieveCategoryById(Long id) {
                Category category = categoryRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Category not found"));
                return categoryMapper.toResponse(category);
        }

        public CategoryResponse createCategory(CategoryRequest categoryRequest) {
                Category category = categoryMapper.toEntity(categoryRequest);
                Category savedCategory = categoryRepository.save(category);
                return categoryMapper.toResponse(savedCategory);
        }

        public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest) {
                Category existingCategory = categoryRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Category not found"));

                existingCategory.setName(categoryRequest.getName());
                return categoryMapper.toResponse(existingCategory);
        }

        public void deleteCategory(Long id) {
                Category existingCategory = categoryRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Category not found"));
                categoryRepository.deleteById(existingCategory.getId());
        }
}

