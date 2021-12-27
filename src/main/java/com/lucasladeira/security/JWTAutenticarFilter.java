package com.lucasladeira.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucasladeira.data.DetalheUsuarioData;
import com.lucasladeira.entities.User;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter{

	public static final int TOKEN_EXPIRACAO = 600_000;
	
	public static final String TOKEN_SENHA = "da932c2d-2b26-4ab9-8799-3b2c21a4e550";
	
	private final AuthenticationManager authenticationManager;
	
	
	public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			User usuario = new ObjectMapper().readValue(request.getInputStream(), User.class);
			
			return authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(usuario.getLogin(), usuario.getPassword(), new ArrayList<>()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Falha ao autenticar usuario", e);
		}
		
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		DetalheUsuarioData usuarioData = (DetalheUsuarioData) authResult.getPrincipal();
		
		String token = JWT.create().withSubject(usuarioData.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
				.sign(Algorithm.HMAC512(TOKEN_SENHA));
		
		response.getWriter().write(token);
		response.getWriter().flush();
	}
	
}
