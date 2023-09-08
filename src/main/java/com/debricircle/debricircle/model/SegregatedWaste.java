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
@Document(collection = "segregated")
public class SegregatedWaste {
	@Id
	@Indexed
	private String id;
	@Indexed
	private String userId;
	private String location;
	private String number;
	private String address;
	private String concrete;
	private String soil;
	private String packaging;
	private String other;
	private String brick;
	private String steel;
	private String wood;
	private String plastic;
	private String totalVolume;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getConcrete() {
		return concrete;
	}

	public void setConcrete(String concrete) {
		this.concrete = concrete;
	}

	public String getSoil() {
		return soil;
	}

	public void setSoil(String soil) {
		this.soil = soil;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getBrick() {
		return brick;
	}

	public void setBrick(String brick) {
		this.brick = brick;
	}

	public String getSteel() {
		return steel;
	}

	public void setSteel(String steel) {
		this.steel = steel;
	}

	public String getWood() {
		return wood;
	}

	public void setWood(String wood) {
		this.wood = wood;
	}

	public String getPlastic() {
		return plastic;
	}

	public void setPlastic(String plastic) {
		this.plastic = plastic;
	}

	public String getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(String totalVolume) {
		this.totalVolume = totalVolume;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "SegregatedWaste [id=" + id + ", userId=" + userId + ", location=" + location + ", number=" + number
				+ ", address=" + address + ", concrete=" + concrete + ", soil=" + soil + ", packaging=" + packaging
				+ ", other=" + other + ", brick=" + brick + ", steel=" + steel + ", wood=" + wood + ", plastic="
				+ plastic + ", totalVolume=" + totalVolume + ", orderDate=" + orderDate + "]";
	}

	public SegregatedWaste(String id, String userId, String location, String number, String address, String concrete,
			String soil, String packaging, String other, String brick, String steel, String wood, String plastic,
			String totalVolume, Date orderDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.location = location;
		this.number = number;
		this.address = address;
		this.concrete = concrete;
		this.soil = soil;
		this.packaging = packaging;
		this.other = other;
		this.brick = brick;
		this.steel = steel;
		this.wood = wood;
		this.plastic = plastic;
		this.totalVolume = totalVolume;
		this.orderDate = orderDate;
	}

}
