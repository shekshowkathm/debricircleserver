package com.debricircle.debricircle.service;

import java.util.List;

import com.debricircle.debricircle.model.AddToCart;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 09-08-2023
 */
public interface IAddToCartService {

	public AddToCart addCart(AddToCart addToCart);

	public List<AddToCart> getAllAddToCart();

	public AddToCart updateAddToCart(AddToCart addToCart);

	public List<AddToCart> getCartByUserID(String userid);

	public void deleteCartByUseridAndProductID(String userid, String productid);

	public AddToCart incrementProductPiece(AddToCart addToCart);

	public AddToCart decrementProductPiece(AddToCart addToCart);

}
