package com.lhg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	//로그인 
	@RequestMapping(value="/login.gr", method = RequestMethod.GET)
	public String grLogin() throws Exception{
		return "login/login";
	}
	
	//회원가입
	@RequestMapping(value="/signUp.gr", method = RequestMethod.GET)
	public String grSignUp() throws Exception{
		return "login/signUp";
	}
	
}
