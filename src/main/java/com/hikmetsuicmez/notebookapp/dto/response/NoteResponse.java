package com.hikmetsuicmez.notebookapp.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class NoteResponse {

        private Long id;
        private String title;
        private String content;
        private LocalDateTime createdAt;
        private String categoryName; // Kategori adı
}
