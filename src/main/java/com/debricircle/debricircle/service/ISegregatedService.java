package com.debricircle.debricircle.service;
/*
 * @Author : Shek Showkath 
 * 
 *@Date : 22-08-2023
 */

import java.util.List;

import com.debricircle.debricircle.model.SegregatedWaste;

public interface ISegregatedService {
	public SegregatedWaste addSegregatedWaste(SegregatedWaste segregatedWaste);

	public List<SegregatedWaste> getAllSegregated();

	public void deleteWasteByID(String id);
}
