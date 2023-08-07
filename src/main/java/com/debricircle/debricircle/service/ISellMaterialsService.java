package com.debricircle.debricircle.service;

import java.util.List;

import com.debricircle.debricircle.model.SellMaterials;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 04-08-2023
 */

public interface ISellMaterialsService {
	
	public SellMaterials addSellMaterials(SellMaterials sellMaterials);
	
	public List<SellMaterials> getAllRegister();
	
	public SellMaterials getSellMaterialsById(String id);
	
	public SellMaterials updateSellMaterials(SellMaterials sellMaterials);
	
	public void deleteById(String id);
}
