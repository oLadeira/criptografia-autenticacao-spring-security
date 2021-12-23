package com.lucasladeira.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasladeira.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public Optional<User> findByLogin(String login);
	
}
