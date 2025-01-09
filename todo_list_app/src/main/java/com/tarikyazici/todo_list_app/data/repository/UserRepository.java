package com.tarikyazici.todo_list_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarikyazici.todo_list_app.data.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
