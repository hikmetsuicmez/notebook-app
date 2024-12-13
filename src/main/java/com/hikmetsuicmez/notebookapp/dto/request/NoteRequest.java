package com.hikmetsuicmez.notebookapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NoteRequest {

        @NotBlank(message = "Title cannot be empty")
        @Size(max = 100, message = "Title cannot exceed 100 characters")
        private String title;

        @NotBlank(message = "Content cannot be empty")
        private String content;

        @NotNull(message = "Category ID cannot be null")
        private Long categoryId;
}
