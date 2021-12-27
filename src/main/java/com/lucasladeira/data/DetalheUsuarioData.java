package com.lucasladeira.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lucasladeira.entities.User;

public class DetalheUsuarioData implements UserDetails{

	private static final long serialVersionUID = 1L;

	private final Optional<User> user;

	public DetalheUsuarioData(Optional<User> user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.orElse(new User()).getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.orElse(new User()).getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true; //retornar true para ele ele valide meu usuario
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true; //retornar true para ele ele valide meu usuario
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true; //retornar true para ele ele valide meu usuario
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true; //retornar true para ele ele valide meu usuario
	}

}
