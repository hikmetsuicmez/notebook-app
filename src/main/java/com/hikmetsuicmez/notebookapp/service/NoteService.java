package com.hikmetsuicmez.notebookapp.service;

import com.hikmetsuicmez.notebookapp.dto.request.NoteRequest;
import com.hikmetsuicmez.notebookapp.dto.response.NoteResponse;
import com.hikmetsuicmez.notebookapp.mapper.NoteMapper;
import com.hikmetsuicmez.notebookapp.model.Category;
import com.hikmetsuicmez.notebookapp.model.Note;
import com.hikmetsuicmez.notebookapp.repository.CategoryRepository;
import com.hikmetsuicmez.notebookapp.repository.NoteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

        private final CategoryRepository categoryRepository;
        private final NoteRepository noteRepository;
        private final NoteMapper noteMapper;

        public List<NoteResponse> retrieveAllNotes() {
                List<Note> notes = noteRepository.findAll();
                return notes
                            .stream()
                            .map(noteMapper::toResponse)
                            .toList();
        }

        public NoteResponse retrieveNoteById(Long id) {
                Note note = noteRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Note not found"));
                return noteMapper.toResponse(note);
        }

        public NoteResponse createNote(NoteRequest noteRequest) {
                Note note = noteMapper.toEntity(noteRequest);

                Category category = categoryRepository.findById(noteRequest.getCategoryId())
                            .orElseThrow(() -> new EntityNotFoundException("Category not found"));

                note.setCategory(category);
                note.setCreatedAt(LocalDateTime.now());
                Note savedNote = noteRepository.save(note);

                return noteMapper.toResponse(savedNote);
        }

        public NoteResponse updateNote(Long id, NoteRequest noteRequest) {
                Note existingNote = noteRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Note not found"));

                existingNote.setTitle(noteRequest.getTitle());
                existingNote.setContent(noteRequest.getContent());
                existingNote.setCreatedAt(LocalDateTime.now());

                if (noteRequest.getCategoryId() != null) {
                        Category category = categoryRepository.findById(noteRequest.getCategoryId())
                                    .orElseThrow(() -> new EntityNotFoundException("Category not found"));
                        existingNote.setCategory(category);
                }

                Note updateNote = noteRepository.save(existingNote);
                return noteMapper.toResponse(updateNote);
        }

        public void deleteNote(Long id) {
                Note existingNote = noteRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Note not found"));

                noteRepository.deleteById(existingNote.getId());
        }


}
