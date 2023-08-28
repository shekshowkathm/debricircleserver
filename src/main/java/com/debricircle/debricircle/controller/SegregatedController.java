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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 * @Author : Shek Showkath 
 * 
 *@Date : 05-08-2023
 */

import com.debricircle.debricircle.model.SegregatedWaste;
import com.debricircle.debricircle.service.ISegregatedService;



@CrossOrigin
@RestController
@RequestMapping("/segregated")
public class SegregatedController {
	
	@Autowired
	private ISegregatedService segregatedService;
	
	@PostMapping("/createsegregated")
	public ResponseEntity<SegregatedWaste> createSegregated(@RequestBody SegregatedWaste segregatedWaste){
		SegregatedWaste saveSegregated=segregatedService.addSegregatedWaste(segregatedWaste);
		return new ResponseEntity<SegregatedWaste>(saveSegregated,HttpStatus.CREATED);
	}
	
	@GetMapping("/claimallsegregatedwaste")
	public ResponseEntity<List<SegregatedWaste>> claimSegregated(){
		List<SegregatedWaste> listOfAllSegregatedWastes=segregatedService.getAllSegregated();
		return new ResponseEntity<List<SegregatedWaste>>(listOfAllSegregatedWastes,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletesegregatedwaste/{id}")
	public ResponseEntity<Void> deleteSegregatedWaste(@PathVariable("id") String id){
		segregatedService.deleteWasteByID(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
