package com.aartek.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.RegistrationDto;
import com.aartek.service.RegistrationService;
import com.aartek.validator.RegistrationValidator;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private RegistrationValidator registrationvalidator;

	@RequestMapping("/registration")
	public String showregistrationPage(Map<String, Object> map) {
		map.put("Registration", new RegistrationDto());
		return "registration";
	}

	@RequestMapping(value = "/saveStudentDeatils", method = { RequestMethod.POST })
	public String saveStudentDeatils(@ModelAttribute("Registration") RegistrationDto registrationDto,
			BindingResult result) {
		// boolean status = false;

		registrationvalidator.validate(registrationDto, result);

		// status = registrationService.saveStudentDeatils(registrationDto);
		if (result.hasErrors()) {

			return "registration";
		} else {
			System.out.println("Registration Controller");
			if (registrationService.saveStudentDeatils(registrationDto) == true) {
				return "welcome";
			}
			return "registration";
		}

	}

	@RequestMapping("/welcome")
	public String showWelcomePage(Map<String, Object> map, Model model) {
		return "welcome";
	}
}
