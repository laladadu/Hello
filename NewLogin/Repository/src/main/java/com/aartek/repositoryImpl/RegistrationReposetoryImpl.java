package com.aartek.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.RegistrationDto;
import com.aartek.repository.RegistrationReposetory;

@Repository
public class RegistrationReposetoryImpl implements RegistrationReposetory {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	 

	 public RegistrationDto saveStudentDeatils(RegistrationDto registration) {
	 
	  List list = hibernateTemplate.find("from  RegistrationDto rd where rd.emailId = ? ", registration.getEmailId());
	  if (list.size() == 0) {

	   hibernateTemplate.saveOrUpdate(registration);
	   System.out.println("insert");
	   return registration;
	  } else {
	   System.out.println("email alredy exist");
	   return null;
	  }
	 }

	// public boolean checkUniqueness(RegistrationDto registration){
	//
	//
	// return true;
	//
	// }
	 
}
