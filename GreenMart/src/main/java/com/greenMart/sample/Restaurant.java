package com.greenMart.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
//	@Data는 클래스안의 모든 private 필드에 대해 @Getter(Getter메소드 생성)와 @Setter를 적용하여
//	세터/게터를 만들어주고 클래스내에 @ToString(toString메서드생성)과
//	@EqualsAndHashCode(equals메서드, hashcode메서드 생성)를 적용시켜
//	메소드를 오버라이드 해주며 @RequiredArgsConstructor(생성자 자동생성,null check실행)를 지정해준다
//	Lombok라이브러리에서 제공
	
	
	//@Autowired는 스프링 내부에서 자신이 특정한 객체에 의존적이므로 자신에게 해당타입의 빈을 주입해주라는 표시이다.
	
	@Setter(onMethod_ = @Autowired) //이 클래스에 Chef클래스가 자동 주입된다.
	//setter메서드의 생성 시 메서드에  추가할 어노테이션을 지정한다. 
	private Chef chef;
	
}
