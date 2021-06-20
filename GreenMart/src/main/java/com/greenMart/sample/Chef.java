package com.greenMart.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // 이것을 통해 해당 객체는 스프링에서 관리해야하는 객체로 인식 되어진다.
@Data // 이것을 통해 해당 객체의 getter,setter,toString이 자동 형성된다(lombok라이브러리 사용자 해당)
public class Chef {

}
