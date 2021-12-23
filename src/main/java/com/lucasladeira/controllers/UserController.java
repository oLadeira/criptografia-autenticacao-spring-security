package com.lucasladeira.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.entities.User;
import com.lucasladeira.repositories.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll(){
		List<User> users = userRepository.findAll();
		return ResponseEntity.ok().body(users);
	}
	
}
