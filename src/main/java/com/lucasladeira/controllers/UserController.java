package com.lucasladeira.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.entities.User;
import com.lucasladeira.repositories.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll(){
		List<User> users = userRepository.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> save(@RequestBody User user){
<<<<<<< HEAD
		user.setPassword(encoder.encode(user.getPassword()));
		user = userRepository.save(user);		
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/validaSenha")
	public ResponseEntity<User> validarSenha(@RequestParam String login, @RequestParam String password){
		
		Optional<User> opt = userRepository.findByLogin(login);
		
		if (opt.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
		boolean valid = false;
		
		valid = encoder.matches(password, opt.get().getPassword());
		
		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		
		return ResponseEntity.status(status.value()).build();
		
	}
	
=======
		user = userRepository.save(user);
		return ResponseEntity.ok().body(user);
	}
	
>>>>>>> 6ae38599e29e16549969c0cad7095b20f5307e3a
}
