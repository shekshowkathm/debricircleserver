package com.debricircle.debricircle.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.debricircle.debricircle.model.Address;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 17-08-2023
 */
public interface IAddressRepository extends MongoRepository<Address, String>{
	public List<Address> findByUserId(String userId);
}
