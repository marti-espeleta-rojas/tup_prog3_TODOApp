package com.todoapp.todoapp.repository;

import com.todoapp.todoapp.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepo extends JpaRepository<Persona, Integer> {
}