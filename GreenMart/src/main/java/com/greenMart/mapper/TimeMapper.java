package com.greenMart.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	//Mapper 인터페이스. 여기에 직접 SQL문을 입력해 관리할 수 있다.
	
	@Select("SELECT sysdate() FROM dual")
	public String getTime();//인터페이스 + 어노테이션 -길고 복잡한 SQL문은 사용할 수 없다
	
	public String getTime2();//인터페이스 + XML
}
