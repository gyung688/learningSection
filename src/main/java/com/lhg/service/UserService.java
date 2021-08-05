package com.lhg.service;

import javax.servlet.http.HttpSession;

import com.lhg.domain.UserVO;

public interface UserService {

	//회원가입
	public void signUp(UserVO userVO) throws Exception;
	
	//아이디 중복체크
	public int chkUserId(UserVO userVO) throws Exception;
	
	//로그인
	public UserVO signin(UserVO userVO) throws Exception;
	
	//로그아웃
	public void signout(HttpSession session) throws Exception;
	
	//회원정보
	public UserVO userInfo(int kUserKey) throws Exception;
	
	//회원정보 수정
	public void userUpdate(UserVO userVO) throws Exception;
	
}
