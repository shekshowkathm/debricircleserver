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

import com.debricircle.debricircle.model.Address;
import com.debricircle.debricircle.service.IAddressService;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 17-08-2023
 */

@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private IAddressService addressService;

	@PostMapping("/createaddress")
	public ResponseEntity<Address> addAddress(@RequestBody Address address) {
		Address saveAddress = addressService.addAddress(address);
		return new ResponseEntity<Address>(saveAddress, HttpStatus.CREATED);
	}

	@GetMapping("/claimalladdress")
	public ResponseEntity<List<Address>> claimAllAddress() {
		List<Address> listOfAllAddress = addressService.getAllAddress();
		return new ResponseEntity<List<Address>>(listOfAllAddress, HttpStatus.OK);
	}

	@GetMapping("/claimaddressbyuserid/{id}")
	public ResponseEntity<List<Address>> claimAddressByUserid(@PathVariable("id") String userid) {
		List<Address> listOfAddressByUserID = addressService.getByUserId(userid);
		return new ResponseEntity<List<Address>>(listOfAddressByUserID, HttpStatus.OK);
	}

	@DeleteMapping("/deleteaddress/{id}")
	public ResponseEntity<Void> deleteAddress(@PathVariable("id") String id) {
		addressService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/claimaddressbyid/{id}")
	public ResponseEntity<Address> getAddressByID(@PathVariable("id") String id) {
		Address addressDetailsByID = addressService.getAddressById(id);
		return new ResponseEntity<Address>(addressDetailsByID, HttpStatus.OK);
	}

	@PutMapping("/updateaddress/{id}")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable("id") String id) {
		Address editAddress = addressService.updateAddress(address, id);
		return new ResponseEntity<Address>(editAddress, HttpStatus.ACCEPTED);
	}
}
