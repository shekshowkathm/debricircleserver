package com.debricircle.debricircle.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.debricircle.debricircle.model.Register;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 04-08-2023
 */
public interface IRegisterRepository extends MongoRepository<Register, String> {
	public boolean existsByEmail(String email);
	public Register findByEmail(String email);
}
