package com.debricircle.debricircle.service;

import java.util.List;

import com.debricircle.debricircle.model.Register;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 04-08-2023
 */
public interface IRegisterService {

	public Register addRegister(Register register);

	public List<Register> getAllRegister();

	public Register getById(String id);

	public Register updateById(Register register,String id);

	public void deleteById(String id);
	
	public boolean isEmailExists(String email);
	
	public Register updatePassword(Register register);

}
