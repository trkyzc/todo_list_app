package com.tarikyazici.todo_list_app.data.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTodoRequest {
	
	 private Long id;
	 
	 @NotEmpty(message = "Title boş bırakılamaz")
	 private String title;
	 private String description;
	 
	 @NotNull(message = "isCompleted null olamaz")
	 private boolean isCompleted;

}
