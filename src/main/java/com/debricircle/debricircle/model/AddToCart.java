package com.debricircle.debricircle.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 09-08-2023
 */
@Document(collection = "addtocart")

public class AddToCart {
	
	@Id
	@Indexed
	private String idAddToCart;
	@Indexed
	private String userId;
	@Indexed
	private String productID;
	private String materialtype;
	private String category;
	private String availability;
	private String quality;
	private String location;
	private String description;
	private String mobileNumber;
	private String productPrice;
	private String quantity;
	private String address;
	private String image;
	private String id;
	private String selectedDate;
	private long piece ;
	public String getIdAddToCart() {
		return idAddToCart;
	}
	public void setIdAddToCart(String idAddToCart) {
		this.idAddToCart = idAddToCart;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSelectedDate() {
		return selectedDate;
	}
	public void setSelectedDate(String selectedDate) {
		this.selectedDate = selectedDate;
	}
	public long getPiece() {
		return piece;
	}
	public void setPiece(long piece) {
		this.piece = piece;
	}
	@Override
	public String toString() {
		return "AddToCart [idAddToCart=" + idAddToCart + ", userId=" + userId + ", productID=" + productID
				+ ", materialtype=" + materialtype + ", category=" + category + ", availability=" + availability
				+ ", quality=" + quality + ", location=" + location + ", description=" + description + ", mobileNumber="
				+ mobileNumber + ", productPrice=" + productPrice + ", quantity=" + quantity + ", address=" + address
				+ ", image=" + image + ", id=" + id + ", selectedDate=" + selectedDate + ", piece=" + piece + "]";
	}
	public AddToCart(String idAddToCart, String userId, String productID, String materialtype, String category,
			String availability, String quality, String location, String description, String mobileNumber,
			String productPrice, String quantity, String address, String image, String id, String selectedDate,
			long piece) {
		super();
		this.idAddToCart = idAddToCart;
		this.userId = userId;
		this.productID = productID;
		this.materialtype = materialtype;
		this.category = category;
		this.availability = availability;
		this.quality = quality;
		this.location = location;
		this.description = description;
		this.mobileNumber = mobileNumber;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.address = address;
		this.image = image;
		this.id = id;
		this.selectedDate = selectedDate;
		this.piece = piece;
	}
	
	
	
		
}
