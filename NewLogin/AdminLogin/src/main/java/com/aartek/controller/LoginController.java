package com.aartek.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.LoginDto;
import com.aartek.service.LoginService;

@Controller
public class LoginController {

	private static Logger log = Logger.getLogger(LoginController.class.getName());

	@RequestMapping("/login") // Listen Request from Dispatcher
	public String showLogin(Map<String, Object> map) {

		log.info("in login");
		// log.debug("This is dedug msg");
		map.put("login", new LoginDto());
		return "login";
	}

	@Autowired // Inject Bean Without any config.
	@Qualifier("LoginServiceImpl") // to reduce ambiguity
	LoginService loginService;

	@RequestMapping(value = "/adminSignIn", method = RequestMethod.POST)

	public String signInAction(@ModelAttribute("login") LoginDto login, ModelMap modelMap, HttpSession hs) {

		log.info("Email Id : " + login.getEmail_id());
		log.info("Password : " + login.getPassword());
		// log.getAppender("SMTPAppender");

		LoginDto dto = loginService.validate(login);
		if (dto != null) {
			hs.setAttribute("login", login);
			log.info("Session ID :  " + hs.getId());
			log.info("Session time :  " + hs.getCreationTime());
			modelMap.put("Email_id", login.getEmail_id());
			return "welcome";
		} else {
			log.info("invalid user");

			return "redirect:/login.do";
		}

	}

	@RequestMapping("/logout")
	public String logoutMethod(HttpSession hs) {
		hs.invalidate();
		log.info("in logout");
		// log.debug("This is dedug msg");
		// modelMap.put("message", email_id);
		return "redirect:/login.do";
	}
	// @ExceptionHandler(CustomException.class)
	// public String getCustom(){}
}
