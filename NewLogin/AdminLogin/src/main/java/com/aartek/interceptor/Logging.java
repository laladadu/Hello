package com.aartek.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class Logging implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("Logging  afterCompletion method");

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {

		System.out.println("Logging postHandle method");
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

		System.out.println("Logging preHandle method");
		request.getSession().setMaxInactiveInterval(2);
		
		 System.out.println("Inside preHandle");
	        if(request.getSession(false)==null){   
	                            System.out.println("Inside if");
	            response.sendRedirect("index.jsp");
	            return false;
	        }
		return true;
	}

}
