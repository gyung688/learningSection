package com.greenMart.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.greenMart.mapper.TimeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TimeMapperTests {

	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime(){
		System.out.println("--------------------");
		System.out.println(timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2(){
		System.out.println("===================");
		System.out.println(timeMapper.getTime2());
	}
	
}
