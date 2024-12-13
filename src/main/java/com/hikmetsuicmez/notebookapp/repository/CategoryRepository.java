package com.hikmetsuicmez.notebookapp.repository;

import com.hikmetsuicmez.notebookapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
