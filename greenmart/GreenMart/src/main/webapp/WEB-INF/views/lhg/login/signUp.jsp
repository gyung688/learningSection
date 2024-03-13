<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<jsp:include page="/WEB-INF/views/template/lhg/header.jsp"/>
<jsp:include page="/WEB-INF/views/template/lhg/container_begin.jsp"/>
<link rel="stylesheet" href="resources/css/lhg/login/signUp.css">
<script>
function test(){
	if($("#signUpPw") == $("#signUpPw_rechk")){
		continue;
	}else{
		alert("비밀번호가 맞지 않습니다.");
	}
}
</script>

<form id="frm" name="frm" method="post" action="/signUp.gr">
<%-- <input type="hidden" id="pageIndex" name="pageIndex" value="${mainVO.pageIndex }"/> --%>
	
	<div class="signUp_area">
		<div class="signUpInfo">
			<div class="signUp_input">
				<div class="signUp_id">
					<span class="sign_sp">아이디</span><br/>
					<input type="text" id="signUpId" name="signUpId">
				</div>
				
				<div class="signUp_pw">
					<span class="sign_sp">비밀번호</span><br/>
					<input type="password" id="signUpPw" name="signUpPw">
				</div>
				<div class="signUp_pw">
					<span class="sign_sp">비밀번호 재확인</span><br/>
					<input type="password" id="signUpPw_rechk" name="signUpPw_rechk">
				</div>
			</div>
			<div class="signUp_logo">
				<a class="logo">
					<img src="resources/img/cmm/logo.jpg" alt="logo">
				</a>
			</div>
			<div class="signUp_btn">
				<a href="#">로그인</a>
			</div>
		</div>
	</div>
	
</form>
		
<jsp:include page="/WEB-INF/views/template/lhg/container_end.jsp"/>
<jsp:include page="/WEB-INF/views/template/lhg/footer.jsp"/>