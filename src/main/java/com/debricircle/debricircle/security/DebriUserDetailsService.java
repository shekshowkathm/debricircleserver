package com.debricircle.debricircle.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.debricircle.debricircle.repository.IRegisterRepository;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 08-08-2023
 */

@Service
public class DebriUserDetailsService implements UserDetailsService {

	@Autowired
	private IRegisterRepository iRegisterRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return iRegisterRepository.findById(username).map(DebriUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("No user found"));
	}

}
