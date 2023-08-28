package com.debricircle.debricircle.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 21-08-2023
 */
@Document(collection = "nonsegregated")
public class NonSegregated {
	@Id
	@Indexed
	private String id;
	@Indexed
	private String userId;
	private String location;
	private long number;
	private String volume;
	private String address;
	private String tippingFees;
	private Date orderDate;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTippingFees() {
		return tippingFees;
	}
	public void setTippingFees(String tippingFees) {
		this.tippingFees = tippingFees;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "NonSegregated [id=" + id + ", userId=" + userId + ", location=" + location + ", number=" + number
				+ ", volume=" + volume + ", address=" + address + ", tippingFees=" + tippingFees + ", orderDate="
				+ orderDate + "]";
	}
	public NonSegregated(String id, String userId, String location, long number, String volume, String address,
			String tippingFees, Date orderDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.location = location;
		this.number = number;
		this.volume = volume;
		this.address = address;
		this.tippingFees = tippingFees;
		this.orderDate = orderDate;
	}
		
}
