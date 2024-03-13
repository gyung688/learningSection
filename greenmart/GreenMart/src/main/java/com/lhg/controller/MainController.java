package com.lhg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhg.service.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;
	
	@RequestMapping(value="/main.gr", method = RequestMethod.GET)
	public String mainPage() throws Exception{
		return "main/main";
	}
	 
}
