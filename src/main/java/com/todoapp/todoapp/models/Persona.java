package com.todoapp.todoapp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dni;
    private String nombre;
    private String apellido;
    private int edad;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Todo> tareas;
}