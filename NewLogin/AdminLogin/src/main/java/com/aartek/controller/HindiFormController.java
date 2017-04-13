package com.aartek.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.HindiDTO;
import com.aartek.service.HindiService;

@Controller
public class HindiFormController {

	@Autowired
	private HindiService hindiService;

	@RequestMapping("/hindiRegistration")
	public String showregistrationPage(Map<String, Object> map) {
		map.put("hindiRegistration", new HindiDTO());
		return "hindiForm";
	}

	@RequestMapping(value = "/saveHindiDeatils", method = { RequestMethod.POST })
	public String saveStudentDeatils(@ModelAttribute("hindiRegistration") HindiDTO hindiDto) {

		System.out.println("At CONTROLLER");
		System.out.println("First name is : " + hindiDto.getFirstName());
		System.out.println("Last Name is : " + hindiDto.getLastName());

		hindiService.saveDetails(hindiDto);
		
		return "welcome";
	}
}
