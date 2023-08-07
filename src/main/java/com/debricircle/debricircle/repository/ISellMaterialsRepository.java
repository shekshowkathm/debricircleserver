package com.debricircle.debricircle.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.debricircle.debricircle.model.SellMaterials;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 04-08-2023
 */
public interface ISellMaterialsRepository extends MongoRepository<SellMaterials, String> {

}
