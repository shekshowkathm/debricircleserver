package com.debricircle.debricircle.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.debricircle.debricircle.model.AddToCart;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 10-08-2023
 *
 *@modified : 14-08-2023
 */

public interface IAddToCartRepository extends MongoRepository<AddToCart, String> {
	public List<AddToCart> findByUserId(String userId);

	public AddToCart findByUserIdAndProductID(String userId, String productID);

	void deleteByUserIdAndProductID(String userId, String productID);
}
