package com.lhg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhg.dao.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDAO loginDAO;

}
