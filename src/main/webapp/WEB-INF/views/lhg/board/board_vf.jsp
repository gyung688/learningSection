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

//수정 페이지
function go_update(){
	document.frm.action="/lhg/board/board_uf";
	document.frm.submit();
}
//삭제
function go_delete(){
	if(confirm("삭제하시겠습니까?")){
		document.frm.action="/lhg/board/board_d";
		document.frm.submit();
	}
}

//목록
function cancel(){
	document.frm.action="/lhg/board/board_lf";
	document.frm.submit();
}

//파일 다운
function fn_fileDown(key){
	if(confirm("파일을 다운 받으시겠습니까?")){
		$("#fileKey").val(key);
		document.frm.action="/lhg/board/fileDown";
		document.frm.submit();
	}
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
				<input type="hidden" id="kUserKey" name="kUserKey" value="${user.kUserKey}">
				<input type="hidden" id="eBoardKey" name="eBoardKey" value="${boardInfo.eBoardKey}">
				<input type="hidden" id="fileKey" name="fileKey" value="">

				<div class="content">
					<div class="content_tit">
						<h2>게시글 상세</h2>
					</div>
				</div>
				
				<div class="tbl_write">
					<table>
						<tbody>
							<tr>
								<th>번호</th>
								<td><c:out value="${boardInfo.eBoardNo}"></c:out></td>
							</tr>
							<tr>
								<th>글 제목</th>
								<td><c:out value="${boardInfo.eBoardTitle}"></c:out></td>
							</tr>
							<tr>
								<th>작성자</th>
								<td><c:out value="${boardInfo.kUserName}"></c:out></td>
							</tr>
							<tr>
								<th>작성일자</th>
								<td><c:out value="${boardInfo.eBoardDate}"></c:out></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><c:out value="${boardInfo.eBoardContent}"></c:out></td>
							</tr>
							<tr>
								<th>파일</th>
								<td>
									<c:forEach var="file" items="${file}">
										<a href="#" onclick="fn_fileDown('${file.file_key}');">${file.org_file_name}</a>(${file.file_size}kb)<br/>
									</c:forEach>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div class="tbl_btn">
					<ul>
						<c:if test="${user.kUserKey == boardInfo.kUserKey}">
							<li>
								<a href="/lhg/board/board_uf?eBoardKey=${boardInfo.eBoardKey}" class="btn" onclick="go_update()">수정</a>
							</li>
							<li>
								<a href="/lhg/board/board_d?eBoardKey=${boardInfo.eBoardKey}" class="btn" onclick="go_delete()">삭제</a>
							</li>
						</c:if>
						<li>
							<a href="/lhg/board/board_lf" class="btn" onclick="cancel()">목록</a>
						</li>
					</ul>
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
