package com.lucasladeira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
=======
>>>>>>> 6ae38599e29e16549969c0cad7095b20f5307e3a

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CriptografiaSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriptografiaSpringSecurityApplication.class, args);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}
