package com.debricircle.debricircle.service;
/*
 * @Author : Shek Showkath 
 * 
 *@Date : 22-08-2023
 */

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debricircle.debricircle.model.SegregatedWaste;
import com.debricircle.debricircle.repository.ISegregatedRepository;

@Service
public class SegregatedService implements ISegregatedService {

	@Autowired
	private ISegregatedRepository segregatedRepository;

	@Override
	public SegregatedWaste addSegregatedWaste(SegregatedWaste segregatedWaste) {
		TimeZone indianTimeZone = TimeZone.getTimeZone("Asia/Kolkata"); // IST time zone
        long currentTimeMillis = System.currentTimeMillis();
        long indianOffset = indianTimeZone.getRawOffset() + (indianTimeZone.inDaylightTime(new Date()) ? indianTimeZone.getDSTSavings() : 0);
        long indianTimeMillis = currentTimeMillis + indianOffset;

        // Create a Date object with the current Indian time
        Date currentIndianTime = new Date(indianTimeMillis);
        segregatedWaste.setOrderDate(currentIndianTime);
		SegregatedWaste saveSegregated = segregatedRepository.save(segregatedWaste);
		return saveSegregated;
	}

	@Override
	public List<SegregatedWaste> getAllSegregated() {
		return segregatedRepository.findAll();
	}

	@Override
	public void deleteWasteByID(String id) {
		segregatedRepository.deleteById(id);
	}

}
