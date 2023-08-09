package com.debricircle.debricircle.jwt;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debricircle.debricircle.exception.UserNotFoundException;
import com.debricircle.debricircle.model.Register;
import com.debricircle.debricircle.repository.IRegisterRepository;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 08-08-2023
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/authenticate")
public class JWTController {

	private final JWTService jwtService;
	private final AuthenticationManager authenticationManager;
	private final IRegisterRepository iRegisterRepository;

	public JWTController(JWTService jwtService, AuthenticationManager authenticationManager,
			IRegisterRepository iRegisterRepository, AuthenticationManager authenticationManager2) {
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
		this.iRegisterRepository = iRegisterRepository;

	}

	@PostMapping("/login")
	public Map getTokenForAuthenticatedUser(@RequestBody JWTAuthenticationRequest authRequest) {
		Map<String, String> response = new HashMap<>();
		String usernames = null;
		String email = null;
		String userid = null;
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			String token = jwtService.generateToken(authRequest.getUserName());
			Register register = iRegisterRepository.findByEmail(authRequest.getUserName());

			usernames = register.getName();
			email = register.getEmail();
			userid = register.getUserId();

			response.put("token", token);
			response.put("name", usernames);
			response.put("email", email);
			response.put("userId", userid);

			return response;
		} else {
			throw new UserNotFoundException("Invalid user credentials");
		}
	}

}
