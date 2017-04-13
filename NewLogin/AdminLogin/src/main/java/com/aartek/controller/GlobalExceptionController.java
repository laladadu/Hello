package com.aartek.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aartek.exception.CustomException;

@ControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(CustomException.class)
	public String getError(CustomException ce, ModelMap map) {
		System.out.println("============= Global Run ===========");
		map.addAttribute("errMsg", "this is Exception.class");
		map.addAttribute("errCode", "00989");

		return "error";
	}
}
