package com.lhg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhg.dao.MainDAO;

@Service
public class MainServiceImpl implements MainService{
	
	@Autowired
	MainDAO mainDAO;

	@Override
	public void insertInfo() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
