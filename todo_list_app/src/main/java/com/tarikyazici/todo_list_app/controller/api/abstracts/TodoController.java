package com.tarikyazici.todo_list_app.controller.api.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tarikyazici.todo_list_app.controller.api.CrudController;
import com.tarikyazici.todo_list_app.data.dto.CreateTodoRequest;
import com.tarikyazici.todo_list_app.data.dto.TodoDto;
import com.tarikyazici.todo_list_app.data.dto.UpdateTodoRequest;

public interface TodoController extends CrudController<TodoDto, CreateTodoRequest, UpdateTodoRequest> {
	
	ResponseEntity<List<TodoDto>> getTodosByUserId(Long userId);
    ResponseEntity<List<TodoDto>> getCompletedTodos();
    ResponseEntity<List<TodoDto>> getPendingTodos();
    ResponseEntity<TodoDto> updateTodoStatus(Long id, boolean status);

}
