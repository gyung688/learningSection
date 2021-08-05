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

//게시판 상세 페이지
function go_view(key){
	$("#eBoardKey").val(key);
	document.frm.action="/lhg/board/board_vf";
	document.frm.submit();
}

//페이징, 검색버튼
function selChange(pageNo){
	console.log("page : " + pageNo);
	$("#nowPage").val(pageNo);
	document.frm.action="/lhg/board/board_lf";
	document.frm.submit();
}

//검색(Enter눌렀을때)
function search_keyDown(){
 	$("#searchWord").keypress(function(event){
 		if(event.which == 13){
 			selChange(1);
 		}
 	})
}

function excelDownload(){
	console.log("haha");
	var frm = document.frm;
	frm.action = "/lhg/board/excelDown";
	frm.submit();
}

function excelUpload(){
	var frm = new FormData(document.getElementById("frm"));
	$.ajax({
		url : "/lhg/board/excelUp",
		data: f,
		processData: false,
		contentType: false,
		type: "POST",
		success: function(data){
			console.log(data);
			frm.result.innerHtmL = JSON.stringify(data);
		}
	})
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
				<input type="hidden" id="nowPage" name="nowPage" value="${paging.nowPage}">
				<input type="hidden" id="eBoardKey" name="eBoardKey">
				<input type="file" id="fileInput" name="fileInput">
				
				<div class="content">
					<div class="content_tit">
						<h2>게시글 목록</h2>
					</div>
				</div>
				<div class="tbl_head">
					<ul>
						<li>
							<select id="cntPerPage" name="cntPerPage" onchange="selChange('1')">
								<option value="5" <c:if test="${paging.cntPerPage == 5}">selected="selected"</c:if>>Page/5</option>
								<option value="10" <c:if test="${paging.cntPerPage == 10}">selected="selected"</c:if>>Page/10</option>
								<option value="15" <c:if test="${paging.cntPerPage == 15}">selected="selected"</c:if>>Page/15</option>
								<option value="20" <c:if test="${paging.cntPerPage == 20}">selected="selected"</c:if>>Page/20</option>
							</select>
						</li>
						<li>
							<select id="searchType" name="searchType">
								<option value="1" selected>전체조회</option>
								<option value="2" <c:if test="${boardVO.searchType eq 2}">selected="selected"</c:if>>제목</option>
								<option value="3" <c:if test="${boardVO.searchType eq 3}">selected="selected"</c:if>>작성자</option>
							</select>
						</li>
						<li>
							<input type="text" id="searchWord" name="searchWord" value="${boardVO.searchWord}" onKeydown="search_keyDown();">
						</li>
						<li>
							<button onclick="selChange('1')">검색</button>
						</li>
					</ul>
				</div>
				<div>
					<ul>
						<li style="list-style:none;">
							<a href="/lhg/board/board_if" class="btn">글 작성</a>
						</li>
					</ul>
				</div>
				
				<div class="tbl_write">
					<table>
						<tbody>
							<tr>
								<th>번호</th>
								<th>글 제목</th>
								<th>작성자</th>
								<th>작성일자</th>
							</tr>
							<c:forEach var="boardList" items="${boardList}" varStatus="i">
								<tr onclick="location.href='/lhg/board/board_vf?eBoardKey=${boardList.eBoardKey}'" style="cursor: pointer;">
									<td><c:out value="${boardList.eBoardNo}"/></td>
									<td><c:out value="${boardList.eBoardTitle}"/></td>
									<td><c:out value="${boardList.kUserName}"/></td>
									<td><c:out value="${boardList.eBoardDate}"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<div>
					<button type="button" onclick="excelUpload()">엑셀업로드</button>
					<button type="button" onclick="excelDownload()">엑셀다운로드</button>
				</div>
				
				<div style="display: block; text-align: center;">		
					<c:if test="${paging.startPage != 1 }">
						<a href="/lhg/board/board_lf?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}&searchType=${boardVO.searchType}&searchWord=${boardVO.searchWord}">&lt;</a>
					</c:if>
					<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
						<c:choose>
							<c:when test="${p == paging.nowPage }">
								<b>${p }</b>
							</c:when>
							<c:when test="${p != paging.nowPage }">
								<a href="/lhg/board/board_lf?nowPage=${p }&cntPerPage=${paging.cntPerPage}&searchType=${boardVO.searchType}&searchWord=${boardVO.searchWord}">${p }</a>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${paging.endPage != paging.lastPage}">
						<a href="/lhg/board/board_lf?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&searchType=${boardVO.searchType}&searchWord=${boardVO.searchWord}">&gt;</a>
					</c:if>
				</div>
				
			</form>		
			
			<div id="result">
			</div>	

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
