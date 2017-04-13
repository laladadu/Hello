package com.aartek.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aartek.model.LoginDto;
import com.aartek.repository.LoginReposetry;
import com.aartek.service.LoginService;
@Service("LoginServiceImpl_2")//give ID for getting at controller Qualifier
public class LoginServiceImpl_2 implements LoginService {

	@Autowired
	@Qualifier("LoginReposetryImpl_2")

	private LoginReposetry loginRepository;
	
	public LoginDto validate(LoginDto logindto) {
		List<LoginDto> list = loginRepository.checkLogin(logindto);
		if (list != null && !list.isEmpty()) {
			System.out.println("SECOND CLASS RUN");

			return list.get(0);
		} else {
			return null;
		}
	}

}
