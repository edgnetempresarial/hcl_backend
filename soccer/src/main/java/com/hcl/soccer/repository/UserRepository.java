package com.hcl.soccer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.soccer.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);

}
