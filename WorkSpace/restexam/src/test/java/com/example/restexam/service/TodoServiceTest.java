package com.example.restexam.service;

import com.example.restexam.domain.Todo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TodoServiceTest {
    @Autowired
    private TodoService todoService;
    private static final Logger log = LoggerFactory.getLogger(TodoServiceTest.class);

    @Test
    void getTodos() {
        List<Todo> todos = todoService.getTodos();
        todos.forEach(todo -> log.info(todo.toString()));
    }

    @Test
    void getTodo() {
        Todo todo = todoService.getTodo(3L);
        log.info(todo.toString());
    }

    @Test
    void addTodo() {
        Todo todo = new Todo("잠자기");
        todoService.addTodo(todo);
    }

    @Test
    void updateTodo() {
        log.info(todoService.getTodo(2L).toString());
        Todo todo = todoService.updateTodo(2L);
        log.info(todoService.getTodo(2L).toString());
    }

    @Test
    void updateTodos() {
        Todo todo = new Todo("데드 리프트");
        todo.setId(2L);
        log.info(todoService.getTodo(5L).toString());
        todoService.updateTodo(todo);
        log.info(todoService.getTodo(5L).toString());
    }

    @Test
    void deleteTodo() {
        todoService.deleteTodo(3L);
        todoService.deleteTodo(4L);
        todoService.deleteTodo(5L);
    }
}