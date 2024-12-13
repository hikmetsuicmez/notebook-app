package com.hikmetsuicmez.notebookapp.controller;

import com.hikmetsuicmez.notebookapp.common.ApiResponse;
import com.hikmetsuicmez.notebookapp.dto.request.CategoryRequest;
import com.hikmetsuicmez.notebookapp.dto.response.CategoryResponse;
import com.hikmetsuicmez.notebookapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

        private final CategoryService categoryService;

        @GetMapping
        public ApiResponse<List<CategoryResponse>> getAllCategories() {
                List<CategoryResponse> list = categoryService.retrieveAllCategories();
                return ApiResponse.success(list);
        }

        @GetMapping("/{id}")
        public ApiResponse<CategoryResponse> getCategoryById(@PathVariable Long id) {
                CategoryResponse categoryResponse = categoryService.retrieveCategoryById(id);
                return ApiResponse.success(categoryResponse);
        }

        @PostMapping
        public ApiResponse<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
                CategoryResponse categoryResponse = categoryService.createCategory(categoryRequest);
                return ApiResponse.success(categoryResponse);
        }

        @PutMapping("/{id}")
        public ApiResponse<CategoryResponse> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest) {
                CategoryResponse categoryResponse = categoryService.updateCategory(id, categoryRequest);
                return ApiResponse.success(categoryResponse);
        }

        @DeleteMapping("/{id}")
        public ApiResponse<String> deleteCategory(@PathVariable Long id) {
                categoryService.deleteCategory(id);
                return ApiResponse.success("Category Deleted");
        }
}
