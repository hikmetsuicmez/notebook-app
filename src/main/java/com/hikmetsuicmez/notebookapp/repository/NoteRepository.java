package com.hikmetsuicmez.notebookapp.repository;

import com.hikmetsuicmez.notebookapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
