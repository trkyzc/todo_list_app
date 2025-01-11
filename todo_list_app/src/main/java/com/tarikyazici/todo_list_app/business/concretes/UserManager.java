package com.tarikyazici.todo_list_app.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tarikyazici.todo_list_app.business.abstracts.UserService;
import com.tarikyazici.todo_list_app.data.dto.CreateUserRequest;
import com.tarikyazici.todo_list_app.data.dto.UpdateUserRequest;
import com.tarikyazici.todo_list_app.data.dto.UserDto;
import com.tarikyazici.todo_list_app.data.entity.User;
import com.tarikyazici.todo_list_app.data.mapper.UserMapper;
import com.tarikyazici.todo_list_app.data.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserManager implements UserService {
	
	private final UserRepository userRepository;
	
	public UserManager(UserRepository userRepository) { // RequiredArgsConstructor
		this.userRepository = userRepository;
	}

	@Override
	public UserDto objectServiceCreate(CreateUserRequest createRequest) {
		
		User user = UserMapper.toEntity(createRequest);
		userRepository.save(user);
		return UserMapper.toDto(user);
	
	}

	@Override
	public List<UserDto> objectServiceList() {
		
		List<User> users =userRepository.findAll();
		return users.stream().map(UserMapper::toDto).collect(Collectors.toList());
		
	}

	@Override
	public UserDto objectServiceFindById(Long id) {
		
		 User user = userRepository.findById(id)
		            .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
		return UserMapper.toDto(user);

	}

	@Override
	public UserDto objectServiceUpdate(Long id, UpdateUserRequest updateRequest) {
		
		User user = userRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
		user.setName(updateRequest.getName());
		user.setUsername(updateRequest.getUsername());
		user.setEmail(updateRequest.getEmail());
		userRepository.save(user);
		return UserMapper.toDto(user);
		 	
	}

	@Override
	public UserDto objectServiceDelete(Long id) {
		
		User user = userRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
		userRepository.delete(user);
		return UserMapper.toDto(user);
	
	}

}
