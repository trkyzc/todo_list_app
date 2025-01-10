package com.tarikyazici.todo_list_app.controller.api.concretes;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tarikyazici.todo_list_app.business.abstracts.TodoService;
import com.tarikyazici.todo_list_app.controller.api.abstracts.TodoController;
import com.tarikyazici.todo_list_app.data.dto.CreateTodoRequest;
import com.tarikyazici.todo_list_app.data.dto.TodoDto;
import com.tarikyazici.todo_list_app.data.dto.UpdateTodoRequest;

@RestController
@RequestMapping("/api/todos")
public class TodoControllerImpl implements TodoController {

    
    private TodoService todoService;
    
    
    public TodoControllerImpl(TodoService todoService) {
        this.todoService = todoService ;
    }

    @PostMapping
    @Override
    public ResponseEntity<TodoDto> create(@RequestBody CreateTodoRequest request) {
        return ResponseEntity.ok(todoService.objectServiceCreate(request));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<TodoDto>> listAll() {
        return ResponseEntity.ok(todoService.objectServiceList());
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<TodoDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.objectServiceFindById(id));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<TodoDto> update(@PathVariable Long id, @RequestBody UpdateTodoRequest request) {
        return ResponseEntity.ok(todoService.objectServiceUpdate(id, request));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<TodoDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.objectServiceDelete(id));
    }

    @GetMapping("/user/{userId}")
    @Override
    public ResponseEntity<List<TodoDto>> getTodosByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(todoService.findTodosByUserId(userId));
    }

    @GetMapping("/completed")
    @Override
    public ResponseEntity<List<TodoDto>> getCompletedTodos() {
        return ResponseEntity.ok(todoService.findCompletedTodos());
    }

    @GetMapping("/pending")
    @Override
    public ResponseEntity<List<TodoDto>> getPendingTodos() {
        return ResponseEntity.ok(todoService.findPendingTodos());
    }

    @PutMapping("/{id}/status")
	@Override
	public ResponseEntity<TodoDto> updateTodoStatus(@PathVariable Long id, @RequestParam boolean status) {
		return ResponseEntity.ok(todoService.updateTodoStatus(id, status));
	}
}
