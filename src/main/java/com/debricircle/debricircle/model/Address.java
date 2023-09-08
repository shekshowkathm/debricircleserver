package com.debricircle.debricircle.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 17-08-2023
 */

@Document(collection = "address")
public class Address {
	@Id
	@Indexed
	private String id;
	@Indexed
	private String userId;
	private String name;
	private String mobileNumber;
	private long pincode;
	private String locality;
	private String address;
	private String city;
	private String landmark;
	private String alternateContact;
	private String state;
	private String addressType;

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getAlternateContact() {
		return alternateContact;
	}

	public void setAlternateContact(String alternateContact) {
		this.alternateContact = alternateContact;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + userId + ", name=" + name + ", mobileNumber=" + mobileNumber
				+ ", pincode=" + pincode + ", locality=" + locality + ", address=" + address + ", city=" + city
				+ ", landmark=" + landmark + ", alternateContact=" + alternateContact + ", state=" + state
				+ ", addressType=" + addressType + "]";
	}

	public Address(String id, String userId, String name, String mobileNumber, long pincode, String locality,
			String address, String city, String landmark, String alternateContact, String state, String addressType) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.pincode = pincode;
		this.locality = locality;
		this.address = address;
		this.city = city;
		this.landmark = landmark;
		this.alternateContact = alternateContact;
		this.state = state;
		this.addressType = addressType;
	}

}
