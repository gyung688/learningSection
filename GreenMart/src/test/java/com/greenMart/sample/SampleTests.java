package com.greenMart.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//@RunWith: 해당 클래스에 있는 코드가 스프링을 실행하는 역할이라는것을 표시
@RunWith(SpringJUnit4ClassRunner.class) 
//지정된 클래스나 문자열을 이용해 필요한 객체들을 스프링 내 객체(빈)로 등록
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j: lombok을 이용해 로그를 기록하는 Logger를 변수로 생성함
@Log4j
public class SampleTests {

	@Autowired
	private Restaurant restaurant;
	
	@Test //JUnit에서 테스트 대상을 표시함
	public void textExit(){
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("----------------------");
		log.info(restaurant.getChef());
	}
	
}
