package com.tarikyazici.todo_list_app.data.mapper;


import com.tarikyazici.todo_list_app.data.dto.CreateTodoRequest;
import com.tarikyazici.todo_list_app.data.dto.TodoDto;
import com.tarikyazici.todo_list_app.data.dto.UpdateTodoRequest;
import com.tarikyazici.todo_list_app.data.entity.Todo;



public class TodoMapper {

    public static TodoDto toDto(Todo todo) {
        if (todo == null) {
            return null;
        }
        TodoDto dto = new TodoDto();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setDescription(todo.getDescription());
        dto.setCompleted(todo.isCompleted());
        //dto.setUser(UserMapper.toDto(todo.getUser()));
        dto.setUserName(todo.getUser().getUsername());
        dto.setCreatedDate(todo.getCreatedDate());
        dto.setUpdatedDate(todo.getUpdatedDate());
        return dto;
    }

    public static Todo toEntity(CreateTodoRequest request) {
        if (request == null) {
            return null;
        }
        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        return todo;
    }

    public static void updateEntity(UpdateTodoRequest request, Todo todo) {
        if (request != null && todo != null) {
            todo.setTitle(request.getTitle());
            todo.setDescription(request.getDescription());
            todo.setCompleted(request.isCompleted());
        }
    }
}
