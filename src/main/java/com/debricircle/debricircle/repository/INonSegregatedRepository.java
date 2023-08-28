package com.debricircle.debricircle.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.debricircle.debricircle.model.NonSegregated;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 10-08-2023
 *
 *@modified : 21-08-2023
 */

public interface INonSegregatedRepository extends MongoRepository<NonSegregated, String>{

}
