package com.tarikyazici.todo_list_app.controller.api.concretes;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarikyazici.todo_list_app.business.abstracts.UserService;
import com.tarikyazici.todo_list_app.controller.api.abstracts.UserController;
import com.tarikyazici.todo_list_app.data.dto.CreateUserRequest;
import com.tarikyazici.todo_list_app.data.dto.UpdateUserRequest;
import com.tarikyazici.todo_list_app.data.dto.UserDto;

@RestController
@RequestMapping("/api/users")
public class UserControllerImpl implements UserController {

    
    private UserService userService;
    
	public UserControllerImpl(UserService userService) {
		this.userService = userService;
	}

    @PostMapping
    @Override
    public ResponseEntity<UserDto> create(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(userService.objectServiceCreate(request));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<UserDto>> listAll() {
        return ResponseEntity.ok(userService.objectServiceList());
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.objectServiceFindById(id));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(userService.objectServiceUpdate(id, request));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<UserDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(userService.objectServiceDelete(id));
    }

}

