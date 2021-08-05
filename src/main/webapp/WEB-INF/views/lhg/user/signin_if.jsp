<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/cmm.css">
<title>Insert title here</title>
</head>
<body>
<script>
$(document).ready(function(){
	var msg = "${msg}";
	
	if(msg == "F"){
		alert("아이디 혹은 비밀번호가 일치하지 않습니다.");
	}
})

//로그인하기
function signin_go(){
	if(chk()){
		document.frm.action = "/lhg/user/signin_i";
		document.frm.submit();
	}
}

//vali
function chk(){
	if($("#kUserId").val() == ""){
		alert("아이디를 입력해주세요.");
		return false;
	}
	
	if($("#kUserPw").val() == ""){
		alert("비밀번호를 입력해주세요.");
		return false;
	}
	return true;
}


</script>
<div id="wrap">
	<header id="header">
		<div id="header_area">
			<%@ include file="../../template/header.jsp" %>
		</div>
	</header>
	
	<nav id="nav">
		<div id="nav_area">
			<%@ include file="../../template/nav.jsp" %>
		</div>
	</nav>
	
	<section id="container">
		<div id="container_area">
			<form id="frm" name="frm" method="post">
				<input type="hidden" id="kUserPass" name="kUserPass">
				
				<div class="content">
					<div class="content_tit">
						<h2>로그인</h2>
					</div>
				</div>
				
				<div class="tbl_write">
					<table>
						<tbody>
							<tr>
								<th>아이디</th>
								<td>
									<input type="text" id="kUserId" name="kUserId" required>
								</td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td><input type="password" id="kUserPw" name="kUserPw" required></td>
							</tr>
						</tbody>
					</table>
					<a href="javascript:void(0);" class="btn" onclick="signin_go()">로그인</a>
				</div>
			</form>
		</div>
	</section>
	
	<footer id="footer">
		<div id="footer_area">
			<%@ include file="../../template/footer.jsp" %>
		</div>
	</footer>
</div>

</body>
</html>
