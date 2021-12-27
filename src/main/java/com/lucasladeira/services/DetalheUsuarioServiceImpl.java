package com.lucasladeira.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.lucasladeira.data.DetalheUsuarioData;
import com.lucasladeira.entities.User;
import com.lucasladeira.repositories.UserRepository;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> usuario = userRepository.findByLogin(username);
		
		if (usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado" );
		}
		
		return new DetalheUsuarioData(usuario);
	}

}
