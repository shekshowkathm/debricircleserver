package com.debricircle.debricircle.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 04-08-2023
 */

@Document(collection = "register")
public class Register {

	@Id
	@Indexed
	private String id;
	@Indexed
	private String userId;
	private String name;
	private String businessname;
	private String businesslocation;
	private String businessaddress;
	private String number;
	private String gst;
	private String password;
	private String email;
	private String role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	public String getBusinesslocation() {
		return businesslocation;
	}

	public void setBusinesslocation(String businesslocation) {
		this.businesslocation = businesslocation;
	}

	public String getBusinessaddress() {
		return businessaddress;
	}

	public void setBusinessaddress(String businessaddress) {
		this.businessaddress = businessaddress;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", userId=" + userId + ", name=" + name + ", businessname=" + businessname
				+ ", businesslocation=" + businesslocation + ", businessaddress=" + businessaddress + ", number="
				+ number + ", gst=" + gst + ", password=" + password + ", email=" + email + ", role=" + role + "]";
	}

	public Register(String id, String userId, String name, String businessname, String businesslocation,
			String businessaddress, String number, String gst, String password, String email, String role) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.businessname = businessname;
		this.businesslocation = businesslocation;
		this.businessaddress = businessaddress;
		this.number = number;
		this.gst = gst;
		this.password = password;
		this.email = email;
		this.role = role;
	}

}
