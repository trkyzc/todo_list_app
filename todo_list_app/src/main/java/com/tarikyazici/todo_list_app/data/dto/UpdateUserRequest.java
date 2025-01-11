package com.tarikyazici.todo_list_app.data.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
	
	 private Long id;
	 
	 @NotEmpty(message = "Name boş bırakılamaz")
	 private String name;
	 
	 @NotEmpty(message = "Username boş bırakılamaz")
	 private String username;
	 
	 @NotEmpty(message = "Email boş bırakılamaz")
	 private String email;

}
