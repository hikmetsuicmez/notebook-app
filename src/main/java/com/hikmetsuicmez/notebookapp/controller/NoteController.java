package com.hikmetsuicmez.notebookapp.controller;


import com.hikmetsuicmez.notebookapp.common.ApiResponse;
import com.hikmetsuicmez.notebookapp.dto.request.NoteRequest;
import com.hikmetsuicmez.notebookapp.dto.response.NoteResponse;
import com.hikmetsuicmez.notebookapp.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@Slf4j
public class NoteController {

        private final NoteService noteService;

        @GetMapping
        public ApiResponse<List<NoteResponse>> retrieveAllNotes() {
                log.info("Fetching all notes"); // Loglama
                List<NoteResponse> list = noteService.retrieveAllNotes();
                log.info("Fetched {} notes", list.size()); // Liste boyutunu logla
                return ApiResponse.success(list);
        }

        @GetMapping("/{id}")
        public ApiResponse<NoteResponse> retrieveNoteById(@PathVariable Long id) {
                log.info("Fetching note by id: {}", id);
                NoteResponse byId = noteService.retrieveNoteById(id);
                log.info("Fetched note by id: {}", byId);
                return ApiResponse.success(byId);
        }

        @PostMapping
        public ApiResponse<NoteResponse> createNote(@RequestBody @Valid NoteRequest noteRequest) {
                log.info("Creating note: {}", noteRequest);
                NoteResponse add = noteService.createNote(noteRequest);
                log.info("Created note: {}", add);
                return ApiResponse.success(add);
        }

        @PutMapping("/{id}")
        public ApiResponse<NoteResponse> updateNote(@PathVariable Long id, @RequestBody @Valid NoteRequest noteRequest) {
                log.info("Updating note with id: {}", id);
                log.debug("Update request: {}", noteRequest);
                NoteResponse update = noteService.updateNote(id, noteRequest);
                log.info("Updated note: {}", update);
                return ApiResponse.success(update);
        }

        @DeleteMapping("/{id}")
        public ApiResponse<String> deleteNote(@PathVariable Long id) {
                log.info("Deleting note with id: {}", id);
                noteService.deleteNote(id);
                log.info("Deleting note with id: {}", id);
                return ApiResponse.success("Note deleted.");
        }

}

