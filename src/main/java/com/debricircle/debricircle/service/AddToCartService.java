package com.debricircle.debricircle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debricircle.debricircle.model.AddToCart;
import com.debricircle.debricircle.repository.IAddToCartRepository;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 09-08-2023
 */
@Service
public class AddToCartService implements IAddToCartService {

	@Autowired
	private IAddToCartRepository addToCartRepository;

	@Override
	public AddToCart addCart(AddToCart addToCart) {
		AddToCart isCartAdded = addToCartRepository.findByUserIdAndProductID(addToCart.getUserId(), addToCart.getId());

		if (isCartAdded != null) {
			return isCartAdded;
		} else {
			addToCart.setProductID(addToCart.getId());
			addToCart.setPiece(1);
			addToCart.setProductPriceForSinglePiece(addToCart.getProductPrice());
			AddToCart saveCart = addToCartRepository.save(addToCart);

			return saveCart;
		}

	}

	@Override
	public List<AddToCart> getAllAddToCart() {
		return addToCartRepository.findAll();
	}

	@Override
	public AddToCart updateAddToCart(AddToCart addToCart) {
		AddToCart updateAddToCart = addToCartRepository.save(addToCart);
		return updateAddToCart;
	}

	@Override
	public List<AddToCart> getCartByUserID(String userid) {
		return addToCartRepository.findByUserId(userid);
	}

	@Override
	public void deleteCartByUseridAndProductID(String userid, String productid) {
		addToCartRepository.deleteByUserIdAndProductID(userid, productid);
	}

	@Override
	public AddToCart incrementProductPiece(AddToCart addToCart) {
		addToCart.setPiece(addToCart.getPiece() + 1);
		addToCart.setProductPrice(addToCart.getProductPriceForSinglePiece() + addToCart.getProductPrice());
		return addToCartRepository.save(addToCart);
	}

	@Override
	public AddToCart decrementProductPiece(AddToCart addToCart) {
		addToCart.setPiece(addToCart.getPiece() - 1);
		addToCart.setProductPrice(addToCart.getProductPrice() - addToCart.getProductPriceForSinglePiece());

		return addToCartRepository.save(addToCart);
	}

}
