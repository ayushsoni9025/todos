package com.ayushsoni9025.todo.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class SpringSecurity {
	
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {

		UserDetails user1 = createNewUser("ayushsoni9025@gmail.com", "Ayush@123");
		UserDetails user2 = createNewUser("ayush9025", "Ayush@123");
		
		return new InMemoryUserDetailsManager(user1,user2);
	}

	
	private UserDetails createNewUser(String username, String password) {
		Function<String,String> passwordEncoder
			= input->passwordEncoder().encode(input);
			
		UserDetails user = User.builder()
				.passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("USER","ADMIN")
				.build();
		return user;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//all url are protected
	//a login form is shown for unauthorized request
	//csrf desable
	//frames
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
	}
}
