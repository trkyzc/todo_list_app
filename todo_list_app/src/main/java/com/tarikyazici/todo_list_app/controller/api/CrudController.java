package com.tarikyazici.todo_list_app.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface CrudController<D, C, U> {

    ResponseEntity<D> create(C createRequest);

    ResponseEntity<List<D>> listAll();

    ResponseEntity<D> getById(Long id);

    ResponseEntity<D> update(Long id, U updateRequest);

    ResponseEntity<D> delete(Long id);
}
