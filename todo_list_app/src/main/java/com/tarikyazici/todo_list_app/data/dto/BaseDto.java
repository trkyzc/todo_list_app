package com.tarikyazici.todo_list_app.data.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class BaseDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;


}
