package com.debricircle.debricircle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debricircle.debricircle.model.Address;
import com.debricircle.debricircle.repository.IAddressRepository;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 17-08-2023
 */

@Service
public class AddressService implements IAddressService {

	@Autowired
	private IAddressRepository iAddressRepository;

	@Override
	public Address addAddress(Address address) {
		Address saveAddress = iAddressRepository.save(address);
		return saveAddress;
	}

	@Override
	public List<Address> getAllAddress() {

		return iAddressRepository.findAll();
	}

	@Override
	public Address updateAddress(Address address, String id) {
		address.setId(id);
		Address updateAddress = iAddressRepository.save(address);
		return updateAddress;
	}

	@Override
	public void deleteById(String id) {
		iAddressRepository.deleteById(id);
	}

	@Override
	public List<Address> getByUserId(String userId) {
		return iAddressRepository.findByUserId(userId);
	}

	@Override
	public Address getAddressById(String id) {
		return iAddressRepository.findById(id).get();
	}

}
