package com.techprimers.db.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.db.model.User;
import com.techprimers.db.repository.UsersRepository;

@RestController
@RequestMapping(value = "/rest/users")
public class UsserResource {

	
	private  UsersRepository repo;
	
	@Autowired
	public UsserResource(UsersRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping(value = "/all")
	public List<User> getAllUser(){
		
		return repo.findAll();
		
	}
	
	@GetMapping(value="/{id}")
	public User getById(@PathVariable("id")Integer id) {
		
		Optional op = repo.findById(id);
		return (User) op.get();
	}
	
	@PostMapping(value = "/register",consumes = "application/json")
	public User newUser(@RequestBody User newUser) {
		
		repo.save(newUser);
		
		return newUser;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id")Integer id){
		
		Optional op = repo.findById(id);
		
		if(!op.isEmpty()) {
			User user = (User)op.get();	
			repo.delete(user);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		else {
		
			return ResponseEntity.noContent().build();
		}
		
		
	}
	
}
