package com.tarikyazici.todo_list_app.business.abstracts;

import com.tarikyazici.todo_list_app.business.CrudService;
import com.tarikyazici.todo_list_app.data.dto.CreateUserRequest;
import com.tarikyazici.todo_list_app.data.dto.UpdateUserRequest;
import com.tarikyazici.todo_list_app.data.dto.UserDto;
import com.tarikyazici.todo_list_app.data.entity.User;

public interface UserService extends CrudService<UserDto, CreateUserRequest, UpdateUserRequest, User> {
	
}
