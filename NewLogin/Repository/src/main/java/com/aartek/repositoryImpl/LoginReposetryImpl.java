package com.aartek.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.LoginDto;
import com.aartek.repository.LoginReposetry;

@Repository("LoginReposetryImpl") // give ID for getting at service Qualifier
public class LoginReposetryImpl implements LoginReposetry {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<LoginDto> checkLogin(LoginDto loginDto) {

		if (loginDto.getEmail_id() != null && loginDto.getPassword() != null) {
			System.out.println("REPO FIRST CLASS RUN");

			System.out.println(loginDto.getEmail_id() + "     " + loginDto.getPassword());
			List<LoginDto> login = hibernateTemplate.find("from LoginDto al where al.email_id = ? and al.password = ?",loginDto.getEmail_id(), loginDto.getPassword());
			if (login != null) {
				return login;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
