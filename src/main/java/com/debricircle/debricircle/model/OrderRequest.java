package com.debricircle.debricircle.model;

import java.math.BigInteger;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author josephine
 * @date 9-OCT-2023
 * 
 */
@Document(collection = "payment")
public class OrderRequest {
	String customerName;
	String email;
	String phoneNumber;
	BigInteger amount;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderRequest [customerName=" + customerName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", amount=" + amount + "]";
	}
}
