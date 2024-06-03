package com.example.restexam.service;

import com.example.restexam.domain.Todo;
import com.example.restexam.repository.TodoRepository;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    //todo 전체 목록 조회
    @Transactional(readOnly = true)
    public List<Todo> getTodos() {
        List<Todo> todos = todoRepository.findAll(Sort.by("id").descending());
        return todos;
    }

    //id로 todo 찾기
    @Transactional(readOnly = true)
    public Todo getTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        return todo;
    }

    //todo 1개 생성하기
    @Transactional
    public Todo addTodo(String todo) {
       return todoRepository.save(new Todo(todo));
    }
    //todo 1개 생성하기
    @Transactional
    public Todo addTodo(Todo todo) {
        return todoRepository.save(new Todo(todo));
    }

    //id에 해당하는 done 만 수정 (했다 안했다 ->토글)
    @Transactional
    public Todo updateTodo(Long id) {
        Todo updateTodo= null;
        try{
            updateTodo = todoRepository.findById(id).orElseThrow();
            updateTodo.setDone(!updateTodo.isDone());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return updateTodo;
    }

    //id에 해당하는 todo 의 정보를 바꾼다
    @Transactional
    public Todo updateTodo(Todo todo) {
        Todo updateTodo = null;
        try{
            updateTodo = todoRepository.save(todo);
        }catch(Exception e){
            e.printStackTrace();
        }
        return updateTodo;
    }

    @Transactional
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
