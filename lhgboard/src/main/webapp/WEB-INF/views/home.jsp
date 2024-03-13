<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<script>
//로그인
function go_insert(){
	document.frm.action = "/user/login";
	document.frm.submit();
}
//회원가입
function go_insert(){
	document.frm.action = "/user/signUp";
	document.frm.submit();
}
</script>
<div id="wrap">
	<header id="header">
		<div id="header_area">
			<%@ include file="template/header.jsp" %>
		</div>
	</header>
	
	<nav id="nav">
		<div id="nav_area">
			<%@ include file="template/nav.jsp" %>
		</div>
	</nav>
	
	<section id="container">
		<div id="container_area">
			<form id="frm" name="frm" method="post" action="/user/signup">
				<ul>
					<li>
						<a onclick="go_login()">로그인</a>
					</li>
					<li>
						<a onclick="go_signUp()">회원가입</a>
					</li>
				</ul>
			</form>
		</div>
	</section>
	
	<footer id="footer">
		<div id="footer_area">
			<%@ include file="template/footer.jsp" %>
		</div>
	</footer>
</div>

</body>
</html>
