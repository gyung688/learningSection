package com.lhg.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lhg.domain.UserVO;

public class UserInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request
			, HttpServletResponse response
			, Object obj) throws Exception{
		
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("user");
		
		if(userVO == null) {
			response.sendRedirect("/lhg/user/signin_if");
			return false;
		}
		return true;
	}
}
