package com.lhg.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.lhg.domain.UserVO;
import com.lhg.service.UserService;

/**
 * 
 * @author SI154
 *
 */
@Controller
@RequestMapping("lhg/user/*")
public class UserController {

	private static final Logger Logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	//회원가입 get
	/**
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/signup_if", method = RequestMethod.GET)
	public void getSignupIf() throws Exception{
		Logger.info("get signup");
	}
	
	//회원가입 post
	@RequestMapping(value = "/signup_i", method = RequestMethod.POST)
	public String postSignupIf(UserVO userVO) throws Exception{
		 String inputPass = userVO.getkUserPw();
		 String pass = passEncoder.encode(inputPass);
		 userVO.setkUserPw(pass);

		 userService.signUp(userVO);
		 
		 return "redirect:/index";
	}
	
	
	//아이디 중복확인
	@RequestMapping(value = "/chkId")
	@ResponseBody
	public String chkId(@ModelAttribute("mesItemVO") UserVO userVO) throws Exception{
		
		System.out.println("id : " + userVO.getkUserId());
		
		int chkCnt = userService.chkUserId(userVO);
		String resultFlag = "T";
		
		if(chkCnt > 0) {
			resultFlag = "F";
		}
		
		System.out.println("resultFlag : " + resultFlag);
		return resultFlag;
	}
	
	//로그인 페이지
	@RequestMapping(value = "/signin_if", method = RequestMethod.GET)
	public void signinIf() throws Exception{
		Logger.info("get signin");
	}
	
	//로그인
	@RequestMapping(value = "/signin_i", method = RequestMethod.POST)
	public String signinI(UserVO userVO
			,	HttpServletRequest request
			,	RedirectAttributes redirect) throws Exception{
		
		HttpSession session = request.getSession();

		int idchk = userService.chkUserId(userVO);

		if(idchk > 0) {
			UserVO signin = userService.signin(userVO);
			
			//사용자가 입력한 패스워드와 데이터 베이스에 저장된 패스워드를 비교해 true,false 반환
			boolean passMatch = passEncoder.matches(userVO.getkUserPw(), signin.getkUserPw());
			
			if(signin != null && passMatch) {
				session.setAttribute("user", signin);
			}else {
				session.setAttribute("user", null); //세션값 제거
				redirect.addFlashAttribute("msg","F"); //특정 페이지로 이동될 때 msg값 부여
				return "redirect:/lhg/user/signin_if";
			}
		}else {
			session.setAttribute("user", null); //세션값 제거
			redirect.addFlashAttribute("msg","F"); //특정 페이지로 이동될 때 msg값 부여
			return "redirect:/lhg/user/signin_if";
		}
		
		return "redirect:/index";
	}
	
	// 로그아웃
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signoutIf(HttpSession session) throws Exception{
		
		userService.signout(session);
		
		return "redirect:/index";
	}
	
	//회원정보
	@RequestMapping(value="/lhg/user/user_info", method = RequestMethod.GET)
	public String userInfo(ModelMap model
			,	HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		int kUserKey = Integer.parseInt(user.getkUserKey());
		
		UserVO userInfo = userService.userInfo(kUserKey);
		model.addAttribute("userInfo", userInfo);
		
		return "lhg/user/user_info";
	}
	
	//회원정보 수정
	@RequestMapping(value="/lhg/user/user_update_view", method = RequestMethod.GET)
	public String userUpdateView(UserVO userVO, ModelMap model) throws Exception{

		int kUserKey = Integer.parseInt(userVO.getkUserKey());
		UserVO userInfo = userService.userInfo(kUserKey);
		model.addAttribute("userInfo", userInfo);

		return "lhg/user/user_update";
	}

	@RequestMapping(value="/lhg/user/user_update", method = RequestMethod.POST)
	public String userUpdate(UserVO userVO, ModelMap model
			,	RedirectAttributes redirect) throws Exception{
		
		userService.userUpdate(userVO);
		
		String key = userVO.getkUserKey();
		redirect.addFlashAttribute("kUserKey", key);
		return "redirect:/lhg/user/user_info";
	}
	
}
