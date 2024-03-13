<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<jsp:include page="/WEB-INF/views/template/lhg/header.jsp"/>
<jsp:include page="/WEB-INF/views/template/lhg/container_begin.jsp"/>
<link rel="stylesheet" href="resources/css/lhg/login/login.css">
<script>

</script>

<form id="frm" name="frm" method="post" action="/login.gr">
<%-- <input type="hidden" id="pageIndex" name="pageIndex" value="${mainVO.pageIndex }"/> --%>
	
	<div class="login_area">
		<div class="login">
			<div class="login_logo">
				<a class="logo">
					<img src="resources/img/cmm/logo.jpg" alt="logo">
				</a>
			</div>
			<div class="login_input">
				<div class="login_id">
					<span class="log_sp">아이디</span><br/>
					<input type="text" id="loginId" name="loginId">
				</div>
				
				<div class="login_pw">
					<span class="log_sp">비밀번호</span><br/>
					<input type="password" id="loginPw" name="loginPw">
				</div>
			</div>
			<div class="login_btn">
				<a href="#">로그인</a>
			</div>
		</div>
	</div>
	
</form>
		
<jsp:include page="/WEB-INF/views/template/lhg/container_end.jsp"/>
<jsp:include page="/WEB-INF/views/template/lhg/footer.jsp"/>