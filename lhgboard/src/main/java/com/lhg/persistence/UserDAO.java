package com.lhg.persistence;

import com.lhg.domain.UserVO;

public interface UserDAO {

	public void signUp(UserVO userVO) throws Exception;
	
	public int chkUserId(UserVO userVO) throws Exception;
	
	public UserVO signin(UserVO userVO) throws Exception;
	
	//회원정보
	public UserVO userInfo(int kUserKey) throws Exception;

	//회원정보 수정
	public void userUpdate(UserVO userVO) throws Exception;
}
