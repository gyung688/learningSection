package com.lhg.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lhg.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSession sql;
	
	//매퍼
	// mapper에 명시해둔 namespace와 동일한 문자열
	private static String namespace = "com.lhg.mappers.userMapper";
	
	@Override
	public void signUp(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".insertSignUp", userVO);
	}

	@Override
	public UserVO signin(UserVO userVO) throws Exception {
		return sql.selectOne(namespace + ".signin", userVO);
	}

	@Override
	public int chkUserId(UserVO userVO) throws Exception {
		return sql.selectOne(namespace + ".chkUserId", userVO);
	}

	@Override
	public UserVO userInfo(int kUserKey) throws Exception {
		return sql.selectOne(namespace + ".userInfo", kUserKey);
	}

	@Override
	public void userUpdate(UserVO userVO) throws Exception {
		sql.selectOne(namespace + ".userUpdate",userVO);
	}

}







