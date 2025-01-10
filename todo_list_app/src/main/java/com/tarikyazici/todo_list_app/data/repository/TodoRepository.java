package com.tarikyazici.todo_list_app.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarikyazici.todo_list_app.data.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
	
	 List<Todo> findByUserId(Long userId);
	 List<Todo> findByIsCompleted(boolean isCompleted);

}
