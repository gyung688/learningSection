<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul>
<c:if test="${user == null}">
	<li>
		<a href="/lhg/user/signin_if">로그인</a>
	</li>
	<li>
		<a href="/lhg/user/signup_if">회원가입</a>
	</li>
</c:if>
<c:if test="${user != null}">
	<li>
		${user.kUserName}님 환영합니다.
	</li>
	<li>
		<a href="/lhg/user/user_info">회원정보</a>
	</li>
	<li>
		<a href="/lhg/board/board_lf">게시판</a>
	</li>
	<li>
		<a href="/lhg/user/signout">로그아웃</a>
	</li>
</c:if>
</ul>