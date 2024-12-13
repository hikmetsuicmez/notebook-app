package com.hikmetsuicmez.notebookapp.controller;


import com.hikmetsuicmez.notebookapp.common.ApiResponse;
import com.hikmetsuicmez.notebookapp.dto.request.NoteRequest;
import com.hikmetsuicmez.notebookapp.dto.response.NoteResponse;
import com.hikmetsuicmez.notebookapp.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

        private final NoteService noteService;

        @GetMapping
        public ApiResponse<List<NoteResponse>> retrieveAllNotes() {
                List<NoteResponse> list = noteService.retrieveAllNotes();
                return ApiResponse.success(list);
        }

        @GetMapping("/{id}")
        public ApiResponse<NoteResponse> retrieveNoteById(@PathVariable Long id) {
                NoteResponse byId = noteService.retrieveNoteById(id);
                return ApiResponse.success(byId);
        }

        @PostMapping
        public ApiResponse<NoteResponse> createNote(@RequestBody NoteRequest noteRequest) {
                NoteResponse add = noteService.createNote(noteRequest);
                return ApiResponse.success(add);
        }

        @PutMapping("/{id}")
        public ApiResponse<NoteResponse> updateNote(@PathVariable Long id, @RequestBody NoteRequest noteRequest) {
                NoteResponse update = noteService.updateNote(id, noteRequest);
                return ApiResponse.success(update);
        }

        @DeleteMapping("/{id}")
        public ApiResponse<String> deleteNote(@PathVariable Long id) {
                noteService.deleteNote(id);
                return ApiResponse.success("Note deleted.");
        }

}

