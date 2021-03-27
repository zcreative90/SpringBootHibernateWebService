package com.techprimers.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techprimers.db.model.User;

public interface UsersRepository extends JpaRepository<User, Integer>{

	
	
}
