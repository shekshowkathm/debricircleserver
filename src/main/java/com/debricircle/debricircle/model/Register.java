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
	private String businessName;
	private String location;
	
	private String mobileNumber;
	private String gst;
	private String businessType;
	private String password;
	@Indexed
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
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
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
		return "Register [id=" + id + ", userId=" + userId + ", name=" + name + ", businessName=" + businessName
				+ ", location=" + location + ", mobileNumber=" + mobileNumber + ", gst=" + gst + ", businessType="
				+ businessType + ", password=" + password + ", email=" + email + ", role=" + role + "]";
	}
	public Register(String id, String userId, String name, String businessName, String location, String mobileNumber,
			String gst, String businessType, String password, String email, String role) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.businessName = businessName;
		this.location = location;
		this.mobileNumber = mobileNumber;
		this.gst = gst;
		this.businessType = businessType;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	

}
