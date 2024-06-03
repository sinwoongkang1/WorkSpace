package com.example.restexam.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String todo;
    private boolean done;

    public Todo(String todo) {
        this.todo = todo;
    }
    public Todo(Todo todo) {
        this.todo = todo.getTodo();
    }
}
