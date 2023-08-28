package com.debricircle.debricircle.service;

import java.util.List;

import com.debricircle.debricircle.model.NonSegregated;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 04-08-2023
 */
public interface INonSegregatedService {
	public NonSegregated addNonSegregated(NonSegregated nonSegregated);

	public List<NonSegregated> getAllNonSegregatedWaste();

	public void deleteByID(String id);
}
