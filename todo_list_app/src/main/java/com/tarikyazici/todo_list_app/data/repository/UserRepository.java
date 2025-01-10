package com.tarikyazici.todo_list_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarikyazici.todo_list_app.data.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	 boolean existsByUsername(String username);
	 boolean existsByEmail(String email);

}
