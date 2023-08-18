package com.debricircle.debricircle.service;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.debricircle.debricircle.model.Register;
import com.debricircle.debricircle.repository.IRegisterRepository;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 04-08-2023
 *
 *@modified : 09-08-2023
 */

@Service
public class RegisterService implements IRegisterService {

	private final PasswordEncoder passwordEncoder;

	public RegisterService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	private IRegisterRepository iRegisterRepository;

	@Override
	public Register addRegister(Register register) {
		register.setRole("USER");
		// Generate a random userid
		long randomUserId = generateRandomUserId();
		register.setUserId(Long.toString(randomUserId));
		register.setId(register.getEmail());
		register.setPassword(passwordEncoder.encode(register.getPassword()));
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
	public Register updateById(Register register,String id) {
		Register userDetails=iRegisterRepository.findById(id).get();
		userDetails.setName(register.getName());
		userDetails.setBusinessName(register.getBusinessName());
		userDetails.setLocation(register.getLocation());
		userDetails.setMobileNumber(register.getMobileNumber());
		userDetails.setGst(register.getGst());
		userDetails.setBusinessType(register.getBusinessType());
		
		System.out.println(userDetails);
		Register updateRegister = iRegisterRepository.save(userDetails);
		return updateRegister;
	}

	@Override
	public void deleteById(String id) {
		iRegisterRepository.deleteById(id);

	}

	/*
	 * Below method generates random numbers
	 */
	private long generateRandomUserId() {
		Random random = new Random();
		long minUserId = 100000L;
		long maxUserId = 999999L;
		return minUserId + random.nextLong() % (maxUserId - minUserId + 1);
	}

	@Override
	public boolean isEmailExists(String email) {
		return iRegisterRepository.existsByEmail(email);
	}

	@Override
	public Register updatePassword(Register register) {
		Register userDetails = iRegisterRepository.findByEmail(register.getEmail());
		userDetails.setPassword(passwordEncoder.encode(register.getPassword()));
		return iRegisterRepository.save(userDetails);
	}

}
