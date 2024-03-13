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
function goUpdate(){
	var frm = document.frm;
	
	frm.method = "get";
	frm.action = "/lhg/user/user_update_view";
	frm.submit();
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
			<form id="frm" name="frm" method="post" action="lhg/user/signup_i">
				<input type="hidden" id="kUserKey" name="kUserKey" value="${userInfo.kUserKey}">    
				
				<div class="content">
					<div class="content_tit">
						<h2>회원정보</h2>
					</div>
				</div>
				
				<div class="tbl_write">
					<table>
						<tbody>
							<tr>
								<th>아이디</th>
								<td><c:out value="${userInfo.kUserId}"/></td>
							</tr>
							<tr>
								<th>이름</th>
								<td><c:out value="${userInfo.kUserName}"/></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td><c:out value="${userInfo.kUserMail}"/></td>
							</tr>
							<tr>
								<th>주소</th>
								<td>
									(<c:out value="${userInfo.kUserPost}"/>)
									<c:out value="${userInfo.kUserAddr}"/>
									<c:out value="${userInfo.kUserAddrDetail}"/>
								</td>
							</tr>
						</tbody>
					</table>
					<input type="button" onclick="javascript:goUpdate('${userInfo.kUserKey}')" class="btn" value="회원정보 수정">
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
