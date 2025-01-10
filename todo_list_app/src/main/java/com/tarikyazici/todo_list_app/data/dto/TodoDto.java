package com.tarikyazici.todo_list_app.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto extends BaseDto {
	
	private String title;
    private String description;
    private boolean isCompleted;
    private String userName;

}
