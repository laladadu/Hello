package com.aartek.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.LoginDto;
import com.aartek.repository.LoginReposetry;
@Repository("LoginReposetryImpl_2")//give ID for getting at service Qualifier
public class LoginReposetryImpl_2 implements LoginReposetry{

	private static Logger log=Logger.getLogger(LoginReposetryImpl_2.class.getName());

	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<LoginDto> checkLogin(LoginDto loginDto) {


		if (loginDto.getEmail_id() != null && loginDto.getPassword() != null) {
			System.out.println("REPO SECOND CLASS RUN");

			System.out.println(loginDto.getEmail_id() + "     " + loginDto.getPassword());
			List<LoginDto> login = hibernateTemplate.find("from LoginDto ld where ld.email_id = ? and ld.password = ?",loginDto.getEmail_id(), loginDto.getPassword());
			log.fatal("fatal run : "+login.get(0));
			return login;
		} else {
			return null;
		}
	}
}
