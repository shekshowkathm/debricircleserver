package com.debricircle.debricircle.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.debricircle.debricircle.model.Register;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 08-08-2023
 */

public class DebriUserDetails implements UserDetails {

	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;

	public DebriUserDetails(Register register) {
		userName = register.getEmail();
		password = register.getPassword();
		authorities = Arrays.stream(register.getRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
