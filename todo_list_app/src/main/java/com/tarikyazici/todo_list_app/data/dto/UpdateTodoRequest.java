package com.tarikyazici.todo_list_app.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTodoRequest {
	
	 private Long id;
	 private String title;
	 private String description;
	 private boolean isCompleted;

}
