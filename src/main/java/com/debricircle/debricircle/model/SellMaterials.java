package com.debricircle.debricircle.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 04-08-2023
 */
@Document(collection = "sellMaterials")
public class SellMaterials {

	@Id
	@Indexed
	private String id;
	@Indexed
	private String userId;
	private String materialtype;
	private String category;
	private String availability;
	private String quality;
	private String location;
	private String description;
	private String number;
	private String productprice;
	private String quantity;
	private String address;
	private String image;
	private String date;

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

	public String getMaterialtype() {
		return materialtype;
	}

	public void setMaterialtype(String materialtype) {
		this.materialtype = materialtype;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getProductprice() {
		return productprice;
	}

	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public SellMaterials(String id, String userId, String materialtype, String category, String availability,
			String quality, String location, String description, String number, String productprice, String quantity,
			String address, String image, String date) {
		super();
		this.id = id;
		this.userId = userId;
		this.materialtype = materialtype;
		this.category = category;
		this.availability = availability;
		this.quality = quality;
		this.location = location;
		this.description = description;
		this.number = number;
		this.productprice = productprice;
		this.quantity = quantity;
		this.address = address;
		this.image = image;
		this.date = date;
	}

	@Override
	public String toString() {
		return "SellMaterials [id=" + id + ", userId=" + userId + ", materialtype=" + materialtype + ", category="
				+ category + ", availability=" + availability + ", quality=" + quality + ", location=" + location
				+ ", description=" + description + ", number=" + number + ", productprice=" + productprice
				+ ", quantity=" + quantity + ", address=" + address + ", image=" + image + ", date=" + date + "]";
	}

}
