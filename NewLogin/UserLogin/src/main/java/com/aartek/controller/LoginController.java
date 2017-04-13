package com.aartek.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.LoginDto;
import com.aartek.service.LoginService;
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
	public String showLogin(Map<String, Object> map) {
		map.put("login", new LoginDto());
		return "login";
	}

	@RequestMapping(value = "/userSignIn", method = RequestMethod.POST)
	public String signInAction(@ModelAttribute("login") LoginDto login) {

		System.out.println(login.getEmail_id());
		System.out.println(login.getPassword());
		return "welcome";
	}
}
