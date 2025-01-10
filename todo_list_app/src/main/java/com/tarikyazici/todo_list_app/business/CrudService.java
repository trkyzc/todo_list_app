package com.tarikyazici.todo_list_app.business;

import java.util.List;

//D: Dto, C: CreateRequest, U: UpdateRequest, E: Entity
public interface CrudService<D, C, U, E> {

	D objectServiceCreate(C createRequest);

	List<D> objectServiceList();

	D objectServiceFindById(Long id);

	D objectServiceUpdate(Long id, U updateRequest);

	D objectServiceDelete(Long id);
}

