package com.lhg.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhg.domain.UserVO;
import com.lhg.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	//회원가입
	@Override
	public void signUp(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		userDAO.signUp(userVO);
	}

	//아이디 중복체크
	@Override
	public int chkUserId(UserVO userVO) throws Exception {
		return userDAO.chkUserId(userVO);
	}

	//로그인
	@Override
	public UserVO signin(UserVO userVO) throws Exception {
		return userDAO.signin(userVO);
		
	}

	//로그아웃
	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate();
	}

	//회원정보 
	@Override
	public UserVO userInfo(int kUserKey) throws Exception {
		return userDAO.userInfo(kUserKey);
	}

	//회원정보 수정
	@Override
	public void userUpdate(UserVO userVO) throws Exception {
		userDAO.userUpdate(userVO);
	}

}
