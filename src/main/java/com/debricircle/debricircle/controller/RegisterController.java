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

import com.debricircle.debricircle.model.Register;
import com.debricircle.debricircle.service.IRegisterService;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 04-08-2023
 */

@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private IRegisterService iRegisterService;

	@PostMapping("/createregister")
	public ResponseEntity<?> createRegister(@RequestBody Register register) {

		if (iRegisterService.isEmailExists(register.getEmail())) {
			return ResponseEntity.badRequest().body("Email already exists");
		}

		Register saveRegister = iRegisterService.addRegister(register);
		return new ResponseEntity<Register>(saveRegister, HttpStatus.CREATED);
	}

	@GetMapping("/claimregister")
	public ResponseEntity<List<Register>> claimAllRegister() {
		List<Register> getAllRegister = iRegisterService.getAllRegister();
		return new ResponseEntity<List<Register>>(getAllRegister, HttpStatus.OK);
	}

	@GetMapping("/claimregisterbyid/{id}")
	public ResponseEntity<Register> claimRegisterById(@PathVariable("id") String registerId) {
		Register getById = iRegisterService.getById(registerId);
		return new ResponseEntity<Register>(getById, HttpStatus.OK);
	}

	@DeleteMapping("/deleteregisterbyid/{id}")
	public ResponseEntity<Void> deleteRegisterById(@PathVariable("id") String registerId) {
		iRegisterService.deleteById(registerId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}

	@PutMapping("/updateregister/{id}")
	public ResponseEntity<Register> updateRegister(@RequestBody Register register) {
		Register updateRegister = iRegisterService.updateById(register);
		return new ResponseEntity<Register>(updateRegister, HttpStatus.OK);
	}
	
	@PutMapping("/updatepassword")
	public ResponseEntity<Register> updatePassword(@RequestBody Register register){
		Register updatePasswordOnly=iRegisterService.updatePassword(register);
		return new ResponseEntity<Register>(updatePasswordOnly,HttpStatus.ACCEPTED);
	}

}
