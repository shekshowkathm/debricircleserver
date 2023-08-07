package com.debricircle.debricircle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debricircle.debricircle.model.SellMaterials;
import com.debricircle.debricircle.service.ISellMaterialsService;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 05-08-2023
 */

@CrossOrigin
@RestController
@RequestMapping("/sellmaterials")
public class SellMaterialsController {

	@Autowired
	private ISellMaterialsService iSellMaterialsService;

	@PostMapping("/createsellmaterials")
	public ResponseEntity<SellMaterials> createSellMaterials(@RequestBody SellMaterials sellMaterials) {
		SellMaterials saveSellMaterial = iSellMaterialsService.addSellMaterials(sellMaterials);
		return new ResponseEntity<SellMaterials>(saveSellMaterial, HttpStatus.CREATED);

	}

	@GetMapping("/claimsellmaterials")
	public ResponseEntity<List<SellMaterials>> claimSellMAterials() {
		List<SellMaterials> listOfAllSellMaterials = iSellMaterialsService.getAllRegister();
		return new ResponseEntity<List<SellMaterials>>(listOfAllSellMaterials, HttpStatus.OK);
	}

	@GetMapping("/claimSellMaterialsByID/{id}")
	public ResponseEntity<SellMaterials> claimSellMAterialsByID(@PathVariable("id") String sellMaterialsId) {
		SellMaterials getByID = iSellMaterialsService.getSellMaterialsById(sellMaterialsId);
		return new ResponseEntity<SellMaterials>(getByID, HttpStatus.OK);
	}

	@PutMapping("/updatesellmaterials/{id}")
	public ResponseEntity<SellMaterials> updateSellMaterials(@RequestBody SellMaterials sellMaterials) {
		SellMaterials updateSellMaterialData = iSellMaterialsService.updateSellMaterials(sellMaterials);
		return new ResponseEntity<SellMaterials>(updateSellMaterialData, HttpStatus.OK);

	}

	@DeleteMapping("/deletesellmaterials/{id}")
	public ResponseEntity<Void> deleteSellMaterials(@PathVariable("id") String sellMaterialsId) {
		iSellMaterialsService.deleteById(sellMaterialsId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}

}
