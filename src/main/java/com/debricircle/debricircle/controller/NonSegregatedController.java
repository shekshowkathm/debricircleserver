package com.debricircle.debricircle.controller;
/*
 * @Author : Shek Showkath 
 * 
 *@Date : 04-08-2023
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debricircle.debricircle.model.NonSegregated;
import com.debricircle.debricircle.service.INonSegregatedService;

@CrossOrigin
@RestController
@RequestMapping("/nonsegregated")
public class NonSegregatedController {
	
	@Autowired
	private INonSegregatedService nonSegregatedService;
	
	@PostMapping("/createnonsegregated")
	public ResponseEntity<NonSegregated> createNonSegregated(@RequestBody NonSegregated nonSegregated){
		NonSegregated saveNonSegregated=nonSegregatedService.addNonSegregated(nonSegregated);
		return new ResponseEntity<NonSegregated>(saveNonSegregated,HttpStatus.CREATED);
	}
	
	@GetMapping("/claimnonsegregated")
	public ResponseEntity<List<NonSegregated>> claimNonSegregated(){
		List<NonSegregated> listOfAllNonSegregated=nonSegregatedService.getAllNonSegregatedWaste();
		return new ResponseEntity<List<NonSegregated>>(listOfAllNonSegregated,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletenonsegregated/{id}")
	public ResponseEntity<Void> deleteNonSegregated(@PathVariable("id") String Id){
		nonSegregatedService.deleteByID(Id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
