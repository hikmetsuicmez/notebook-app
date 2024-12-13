package com.hikmetsuicmez.notebookapp.controller;

import com.hikmetsuicmez.notebookapp.common.ApiResponse;
import com.hikmetsuicmez.notebookapp.dto.request.CategoryRequest;
import com.hikmetsuicmez.notebookapp.dto.response.CategoryResponse;
import com.hikmetsuicmez.notebookapp.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

        private final CategoryService categoryService;

        @GetMapping
        public ApiResponse<List<CategoryResponse>> getAllCategories() {
                log.info("Fetching all categories"); // Loglama
                List<CategoryResponse> list = categoryService.retrieveAllCategories();
                log.info("Fetched {} categories", list.size()); // Liste boyutunu logla
                return ApiResponse.success(list);
        }

        @GetMapping("/{id}")
        public ApiResponse<CategoryResponse> getCategoryById(@PathVariable Long id) {
                log.info("Fetching category with id: {}", id);
                CategoryResponse byId = categoryService.retrieveCategoryById(id);
                log.info("Fetched category:  {}", byId);
                return ApiResponse.success(byId);
        }

        @PostMapping
        public ApiResponse<CategoryResponse> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
                log.info("Creating category: {}", categoryRequest);
                CategoryResponse add = categoryService.createCategory(categoryRequest);
                log.info("Created category: {}", add);
                return ApiResponse.success(add);
        }

        @PutMapping("/{id}")
        public ApiResponse<CategoryResponse> updateCategory(@PathVariable Long id, @RequestBody @Valid CategoryRequest categoryRequest) {
                log.info("Updating category with id: {}", id);
                log.debug("Update request: {}", categoryRequest);
                CategoryResponse update = categoryService.updateCategory(id, categoryRequest);
                log.info("Updated category: {}", update);
                return ApiResponse.success(update);
        }

        @DeleteMapping("/{id}")
        public ApiResponse<String> deleteCategory(@PathVariable Long id) {
                log.info("Deleting category with id: {}", id);
                categoryService.deleteCategory(id);
                log.info("Deleting category with id: {}", id);
                return ApiResponse.success("Category Deleted");
        }
}
