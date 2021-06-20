package com.greenMart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 스프링 IOC Container에게 해당 클래스를 Bean구성 Class임을 알려주는 어노테이션
@Configuration
// root-context.xml에 <context:comp~~>와 같은 역할 수행
@ComponentScan(basePackages= {"com.greenMart.sample"})
public class RootConfig {

}
