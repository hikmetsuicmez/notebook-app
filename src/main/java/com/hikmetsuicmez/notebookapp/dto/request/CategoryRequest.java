package com.hikmetsuicmez.notebookapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryRequest {

        @NotBlank(message = "Category name cannot be empty")
        @Size(max = 50, message = "Category name cannot exceed 50 characters")
        private String name;
}
