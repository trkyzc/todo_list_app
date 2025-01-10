package com.tarikyazici.todo_list_app.business.abstracts;

import java.util.List;

import com.tarikyazici.todo_list_app.business.CrudService;
import com.tarikyazici.todo_list_app.data.dto.CreateTodoRequest;
import com.tarikyazici.todo_list_app.data.dto.TodoDto;
import com.tarikyazici.todo_list_app.data.dto.UpdateTodoRequest;
import com.tarikyazici.todo_list_app.data.entity.Todo;

public interface TodoService extends CrudService<TodoDto, CreateTodoRequest, UpdateTodoRequest, Todo> {
    List<TodoDto> findTodosByUserId(Long userId);
    List<TodoDto> findCompletedTodos();
    List<TodoDto> findPendingTodos();
    TodoDto updateTodoStatus(Long id, boolean status);
}
