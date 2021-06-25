package com.greenMart.service;

import com.greenMart.model.MemberVO;

public interface MemberService {

	//회원가입
	public void memberJoin(MemberVO member) throws Exception;
}
