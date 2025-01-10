package com.tarikyazici.todo_list_app.controller.api.abstracts;

import com.tarikyazici.todo_list_app.controller.api.CrudController;
import com.tarikyazici.todo_list_app.data.dto.CreateUserRequest;
import com.tarikyazici.todo_list_app.data.dto.UpdateUserRequest;
import com.tarikyazici.todo_list_app.data.dto.UserDto;

public interface UserController extends CrudController<UserDto,CreateUserRequest, UpdateUserRequest> {  //D, C, U

}
