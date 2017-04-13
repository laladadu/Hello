package com.aartek.validator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.aartek.model.RegistrationDto;
import com.aartek.repository.RegistrationReposetory;

@Component
public class RegistrationValidator implements Validator {
	
	@Autowired
	private RegistrationReposetory registrationReposetory;

Locale locale=Locale.ENGLISH;
	public boolean supports(Class<?> clazz) {
		return RegistrationDto.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {

		RegistrationDto registrationDto = (RegistrationDto) target;

		// ValidationUtils.rejectIfEmpty(errors, "firstName", "Please Enter
		// FirstName");
		// ValidationUtils.rejectIfEmpty(errors, "lastName", "Please Enter
		// lastName");
		// ValidationUtils.rejectIfEmpty(errors, "emailId", "Please Enter
		// emailId");
		// ValidationUtils.rejectIfEmpty(errors, "contact", "Please Enter
		// contact");
		// ValidationUtils.rejectIfEmpty(errors, "password", "Please Enter
		// password");


		if (registrationDto.getFirstName() != "" && registrationDto.getFirstName().matches("[a-zA-Z]{2,25}") != true) {
			errors.rejectValue("firstName", "error.firstname.first.rule");
		} else {

			ValidationUtils.rejectIfEmpty(errors, "firstName", "error.firstName.empty");

		}

		if (registrationDto.getLastName() != "" && registrationDto.getLastName().matches("[a-zA-Z]{2,25}") != true) {
			errors.rejectValue("lastName", "error.lastname.first.rule");
		} else {
			ValidationUtils.rejectIfEmpty(errors, "lastName", "error.lastName.empty");
		}

		if (registrationDto.getEmailId() != "" && registrationDto.getEmailId().contains("@gmail.com") != true) {
			errors.rejectValue("emailId", "error.email.first.rule");
		}
		
//		else if(registrationReposetory.saveStudentDeatils(registrationDto)==null)
//		{
//			errors.rejectValue("emailId", "error.email.second.rule");
//			}
		
		else {
			ValidationUtils.rejectIfEmpty(errors, "emailId", "error.email.empty");
		}

		if (registrationDto.getContact() != "" && registrationDto.getContact().matches("[789]{1}[0-9]{9}") != true) {
			errors.rejectValue("contact", "error.contact.first.rule");
		} else {
			ValidationUtils.rejectIfEmpty(errors, "contact", "error.contact.empty");
		}
		if (registrationDto.getPassword() != "" && registrationDto.getPassword().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[#?!@$%^&*-]).{8,20})") != true) {
			errors.rejectValue("password", "error.password.first.rule");
		} else {

			ValidationUtils.rejectIfEmpty(errors, "password", "error.password.empty");

		}
	}

}
