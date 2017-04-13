package com.aartek.repository;

import java.util.List;

import com.aartek.model.LoginDto;


public interface LoginReposetry {

	
	public List<LoginDto> checkLogin(LoginDto loginDto) ;
		
}
