package com.todo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.todo.model.Todo;

@Repository
public interface TodoDao extends JpaRepository<Todo, Integer>{
	
}
