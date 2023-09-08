package com.debricircle.debricircle.service;

import java.util.List;

import com.debricircle.debricircle.model.Address;
/*
 * @Author : Shek Showkath 
 * 
 *@Date : 17-08-2023
 */

public interface IAddressService {

	public Address addAddress(Address address);

	public List<Address> getAllAddress();

	public Address getAddressById(String id);

	public Address updateAddress(Address address, String id);

	public void deleteById(String id);

	public List<Address> getByUserId(String userId);

}
