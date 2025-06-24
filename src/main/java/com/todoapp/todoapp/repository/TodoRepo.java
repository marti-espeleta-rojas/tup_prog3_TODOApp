package com.todoapp.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todoapp.todoapp.models.Todo;

public interface TodoRepo extends JpaRepository<Todo, Integer> {
}