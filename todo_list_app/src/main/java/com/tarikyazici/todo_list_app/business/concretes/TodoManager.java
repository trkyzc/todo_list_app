package com.tarikyazici.todo_list_app.business.concretes;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.tarikyazici.todo_list_app.business.abstracts.TodoService;
import com.tarikyazici.todo_list_app.data.dto.CreateTodoRequest;
import com.tarikyazici.todo_list_app.data.dto.TodoDto;
import com.tarikyazici.todo_list_app.data.dto.UpdateTodoRequest;
import com.tarikyazici.todo_list_app.data.entity.Todo;
import com.tarikyazici.todo_list_app.data.entity.User;
import com.tarikyazici.todo_list_app.data.mapper.TodoMapper;
import com.tarikyazici.todo_list_app.data.repository.TodoRepository;
import com.tarikyazici.todo_list_app.data.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TodoManager implements TodoService {
	
	private final TodoRepository todoRepository;
	private final UserRepository userRepository;
	
	
	public TodoManager(TodoRepository todoRepository, UserRepository userRepository) {   //RequiredArgsConstructor
		this.todoRepository = todoRepository;
		this.userRepository = userRepository;
	}

	@Override
	public TodoDto objectServiceCreate(CreateTodoRequest createRequest) {
		
		User user = userRepository.findById(createRequest.getUserId())
	            .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + createRequest.getUserId()));
		
		Todo todo = TodoMapper.toEntity(createRequest);
		todo.setUser(user);
		todoRepository.save(todo);
		return TodoMapper.toDto(todo);
	}

	@Override
	public List<TodoDto> objectServiceList() {
		
		List<Todo> todo =todoRepository.findAll();
		return todo.stream().map(TodoMapper::toDto).collect(Collectors.toList());
		
	}

	@Override
	public TodoDto objectServiceFindById(Long id) {
		
		Todo todo = todoRepository.findById(id)
		        .orElseThrow(() -> new EntityNotFoundException("Todo not found with id: " + id));
		return TodoMapper.toDto(todo);

	}

	@Override
	public TodoDto objectServiceUpdate(Long id, UpdateTodoRequest updateRequest) {
		
		Todo todo = todoRepository.findById(id)
		        .orElseThrow(() -> new EntityNotFoundException("Todo not found with id: " + id));
		TodoMapper.updateEntity(updateRequest, todo);
		todoRepository.save(todo);
		return TodoMapper.toDto(todo);
	}

	@Override
	public TodoDto objectServiceDelete(Long id) {
		
		Todo todo = todoRepository.findById(id)
		        .orElseThrow(() -> new EntityNotFoundException("Todo not found with id: " + id));
		todoRepository.delete(todo);
		return TodoMapper.toDto(todo);
	
	}

	@Override
	public List<TodoDto> findTodosByUserId(Long userId) {
		
		List<Todo> todo = todoRepository.findByUserId(userId);
		return todo.stream().map(TodoMapper::toDto).collect(Collectors.toList());
	
	}

	@Override
	public List<TodoDto> findCompletedTodos() {
		
		List<Todo> todo = todoRepository.findByIsCompleted(true);
		return todo.stream().map(TodoMapper::toDto).collect(Collectors.toList());
		
	}

	@Override
	public List<TodoDto> findPendingTodos() {
		
		List<Todo> todo = todoRepository.findByIsCompleted(false);
		return todo.stream().map(TodoMapper::toDto).collect(Collectors.toList());

	}

	@Override
	public TodoDto updateTodoStatus(Long id, boolean status) {
		
		Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo not found with id: " + id));
        todo.setCompleted(status);
        todoRepository.save(todo);
        return TodoMapper.toDto(todo);
	}

}
