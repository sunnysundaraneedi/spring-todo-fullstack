package com.todo.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.todo.todo.model.Todo;
import com.todo.todo.repository.TodoDao;
@Service
public class TodoService {
	
	@Autowired
	TodoDao todoDao;
	public List<Todo> getAllTodos() {
		return todoDao.findAll();
	}
	public ResponseEntity<String> addTodo(Todo todo) {
		todoDao.save(todo);
		return new ResponseEntity<>("Todo added", HttpStatus.CREATED);
	}
	public ResponseEntity<String> deleteTodo(Integer id) {
		// TODO Auto-generated method stub
		todoDao.deleteById(id);
		return new ResponseEntity<>("Todo deleted", HttpStatus.NO_CONTENT);
	}
	public ResponseEntity<String> updateTodo(Todo todo, Integer id) {
		// TODO Auto-generated method stub
		try {
			Todo todo1 = todoDao.findById(id).orElse(null);
			if(todo1!=null) {
				System.out.println(todo.getStatus());
				todo1.setStatus(todo.getStatus());
				todoDao.save(todo1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("Todo updated", HttpStatus.CREATED);
	} 
	
}
