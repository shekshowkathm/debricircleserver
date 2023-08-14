package com.debricircle.debricircle.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.debricircle.debricircle.jwt.JWTAuthenticationFilter;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 08-08-2023
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JWTAuthenticationFilter authenticationFilter;

	@Autowired
	private DebriUserDetailsService debriUserDetailsService;

	private static final String[] SECURED_URLs = { 
			"/register/claimregister", 
			
	};
	private static final String[] SPECIAL_URLs = { 
			"/register/claimregisterbyid/{id}", 
			"/sellmaterials/createsellmaterials",
			
			"/sellmaterials/getbyuseridandid/{userid}/{id}",
			"/addtocart/createcart",
			"/addtocart/claimaddtocart",
			"/addtocart/updatepiece",
			"/addtocart/getcartdetails/{userid}",
			"/addtocart/removecart/{userid}/{productId}",
			"/addtocart/incrementpieceofproduct",
			"/addtocart/decrementpieceofproduct",
			
			
	};
	private static final String[] UN_SECURED_URLs = { 
			"/register/createregister", "/authenticate/login" ,
			"/register/updatepassword",
			"/sellmaterials/claimsellmaterials"
			
	};

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		var authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(debriUserDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.cors().and()
				.csrf().disable().authorizeHttpRequests().requestMatchers(UN_SECURED_URLs).permitAll().and()
				.authorizeHttpRequests().requestMatchers(SECURED_URLs).hasAnyAuthority("ADMIN")
				.requestMatchers(SPECIAL_URLs).hasAuthority("USER").anyRequest().authenticated().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authenticationProvider(authenticationProvider())
				.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class).build();

	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

}
