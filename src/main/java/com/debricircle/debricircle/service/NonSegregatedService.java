package com.debricircle.debricircle.service;
/*
 * @Author : Shek Showkath 
 * 
 *@Date : 04-08-2023
 *
 *@modified : 09-08-2023
 */

import java.util.List;
import java.util.Date;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debricircle.debricircle.model.NonSegregated;
import com.debricircle.debricircle.repository.INonSegregatedRepository;

@Service
public class NonSegregatedService implements INonSegregatedService {

	@Autowired
	private INonSegregatedRepository nonSegregatedRepository;

	@Override
	public NonSegregated addNonSegregated(NonSegregated nonSegregated) {
		TimeZone indianTimeZone = TimeZone.getTimeZone("Asia/Kolkata"); // IST time zone
        long currentTimeMillis = System.currentTimeMillis();
        long indianOffset = indianTimeZone.getRawOffset() + (indianTimeZone.inDaylightTime(new Date()) ? indianTimeZone.getDSTSavings() : 0);
        long indianTimeMillis = currentTimeMillis + indianOffset;

        // Create a Date object with the current Indian time
        Date currentIndianTime = new Date(indianTimeMillis);
		nonSegregated.setOrderDate(currentIndianTime);
		NonSegregated saveNonSegregated = nonSegregatedRepository.save(nonSegregated);
		return saveNonSegregated;
	}

	@Override
	public List<NonSegregated> getAllNonSegregatedWaste() {

		return nonSegregatedRepository.findAll();
	}

	@Override
	public void deleteByID(String id) {

		nonSegregatedRepository.deleteById(id);
	}

}
