package com.aartek.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.HindiDTO;
import com.aartek.repository.HindiReposetry;
import com.aartek.service.HindiService;

@Service
public class HindiServiceImpl implements HindiService{

	@Autowired
	private HindiReposetry hindiReposetry;
	
	public boolean saveDetails(HindiDTO hindiDto){
		
		System.out.println("At service");
		System.out.println("First name is : " + hindiDto.getFirstName());
		System.out.println("Last Name is : " + hindiDto.getLastName());

		hindiReposetry.saveHindiDetail(hindiDto);
		return true;
		
	}
}
