package com.aartek.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.RegistrationDto;
import com.aartek.repository.RegistrationReposetory;
import com.aartek.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationReposetory registrationReposetory;

	public boolean saveStudentDeatils(RegistrationDto registration) {

		RegistrationDto registrationDto = registrationReposetory.saveStudentDeatils(registration);

		if (registrationDto != null) {
			return true;
		}

		else {
			return false;
		}
	}

}
