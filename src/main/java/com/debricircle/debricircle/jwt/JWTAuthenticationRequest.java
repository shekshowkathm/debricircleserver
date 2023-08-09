package com.debricircle.debricircle.jwt;

import lombok.Data;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 08-08-2023
 */
@Data
public class JWTAuthenticationRequest {
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JWTAuthenticationRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "JWTAuthenticationRequest [userName=" + userName + ", password=" + password + "]";
	}
}