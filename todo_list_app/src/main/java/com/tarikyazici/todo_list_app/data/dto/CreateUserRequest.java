package com.tarikyazici.todo_list_app.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
	
	 private String name;
	 private String username;
	 private String email;
	 private String password;

}
