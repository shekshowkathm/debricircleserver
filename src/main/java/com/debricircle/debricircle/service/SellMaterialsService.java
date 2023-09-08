package com.debricircle.debricircle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debricircle.debricircle.model.SellMaterials;
import com.debricircle.debricircle.repository.ISellMaterialsRepository;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 04-08-2023
 */

@Service
public class SellMaterialsService implements ISellMaterialsService {

	@Autowired
	private ISellMaterialsRepository iSellMaterialsRepository;

	@Override
	public SellMaterials addSellMaterials(SellMaterials sellMaterials) {
		SellMaterials saveSellMaterials = iSellMaterialsRepository.save(sellMaterials);
		return saveSellMaterials;
	}

	@Override
	public List<SellMaterials> getAllRegister() {

		return iSellMaterialsRepository.findAll();
	}

	@Override
	public SellMaterials getSellMaterialsById(String id) {

		return iSellMaterialsRepository.findById(id).get();
	}

	@Override
	public SellMaterials updateSellMaterials(SellMaterials sellMaterials) {
		SellMaterials updateSellMaterials = iSellMaterialsRepository.save(sellMaterials);
		return updateSellMaterials;
	}

	@Override
	public void deleteById(String id) {
		iSellMaterialsRepository.deleteById(id);

	}

	@Override
	public SellMaterials getByuserIDAndID(String userid, String id) {

		return iSellMaterialsRepository.findByUserIdAndId(userid, id);
	}

}
