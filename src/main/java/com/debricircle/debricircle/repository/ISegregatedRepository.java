package com.debricircle.debricircle.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.debricircle.debricircle.model.SegregatedWaste;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 22-08-2023
 */
public interface ISegregatedRepository extends MongoRepository<SegregatedWaste, String> {

}
