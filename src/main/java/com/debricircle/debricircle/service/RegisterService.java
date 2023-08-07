package com.debricircle.debricircle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debricircle.debricircle.model.Register;
import com.debricircle.debricircle.repository.IRegisterRepository;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 04-08-2023
 */

@Service
public class RegisterService implements IRegisterService {

	@Autowired
	private IRegisterRepository iRegisterRepository;

	@Override
	public Register addRegister(Register register) {
		Register saveRegister = iRegisterRepository.save(register);
		return saveRegister;
	}

	@Override
	public List<Register> getAllRegister() {

		return iRegisterRepository.findAll();
	}

	@Override
	public Register getById(String id) {

		return iRegisterRepository.findById(id).get();
	}

	@Override
	public Register updateById(Register register) {
		Register updateRegister = iRegisterRepository.save(register);
		return updateRegister;
	}

	@Override
	public void deleteById(String id) {
		iRegisterRepository.deleteById(id);

	}

}
