package com.todo.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todo.model.Todo;
import com.todo.todo.service.TodoService;

@RestController
@RequestMapping("todos")
@CrossOrigin(origins = "http://localhost:5173")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	@GetMapping("all-todos")
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	} 
	
	@PostMapping("add-new")
	public ResponseEntity<String> addTodo(@RequestBody Todo todo){
		return todoService.addTodo(todo);
	}
	
	@DeleteMapping("delete-todo/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable Integer id){
		return todoService.deleteTodo(id);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<String> updateTodo(@RequestBody Todo todo, @PathVariable Integer id){
		return todoService.updateTodo(todo, id);
	}
	
	
}
