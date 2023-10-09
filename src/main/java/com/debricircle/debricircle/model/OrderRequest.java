package com.debricircle.debricircle.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author josephine
 * @date 9-OCT-2023
 * 
 */
@Document(collection = "payment")
public class OrderRequest {

	@Id
	private String id;
	private String customerName;
	private String email;
	private String phoneNumber;
	private BigInteger amount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
		return "OrderRequest [id=" + id + ", customerName=" + customerName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", amount=" + amount + "]";
	}

}
