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
 	$(".eBoardDate").text(nowDate());
	$("#eBoardDate").val(nowDate());
})

//오늘 날짜
function nowDate(){
	var date = new Date();
	var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1 ) : date.getMonth() + 1;
	var year = date.getFullYear();
	var day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
	var nowDate = year + "-" + month + "-" + day;
	
	return nowDate;
}

//수정
function update_go(){
	if(chk()){
		if(confirm("수정하시겠습니까?")){
			document.frm.action="/lhg/board/board_u";
			document.frm.submit();
		}
	}
}
//수정 vali
function chk(){
	if($("#eBoardTitle").val() == ""){
		alert("제목을 입력해주세요.");
		return false;
	}
	
	if($("#eBoardContent").val() == ""){
		alert("내용을 입력해주세요.");
		return false;
	}
	return true;
}

//목록
function cancel(){
	if(chkCan()){
		document.frm.action="/lhg/board/board_lf";
		document.frm.submit();
	}
}
//목록 vali
function chkCan(){
	if($("#eBoardTitle").val() != "" || $("#eBoardContent").val() != ""){
		if(confirm("작성 중인 글이 있습니다. 나가시겠습니까?")){
			return true;
		}
	}else{
		return true;
	}
}

//파일 추가
var rowIndex = 0;
function add_file(){
	var innerStr = "";
	
	innerStr += "	<tr>";
	innerStr += "		<td>";
	innerStr += "			<a class='del' onclick='delRow(this);'>X</a>";
	innerStr += "		</td>";
	innerStr += "		<td>";
	innerStr += "			<input type='file' id='file_" + rowIndex + "' name='file_" + rowIndex + "'>";
	innerStr += "		</td>";
	innerStr += "	</tr>";
	
	$("#lineRow").append(innerStr);
	rowIndex++;
}

//행 삭제
function delRow(obj){
	var tr = $(obj).parent().parent();
	tr.remove();
}

//기존 파일 제거
var fileNoArry = new Array();
var fileNameArry = new Array();
function fn_del(value, name, obj){
	
	fileNoArry.push(value);
	fileNameArry.push(name);
	$("#fileNoDel").attr("value", fileNoArry);
	$("#fileNameDel").attr("value", fileNameArry);
	delRow(obj);
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
			<form id="frm" name="frm" method="post" action="/board/board_u" enctype="multipart/form-data">
				<input type="hidden" id="kUserKey" name="kUserKey" value="${user.kUserKey}">
				<input type="hidden" id="eBoardKey" name="eBoardKey" value="${boardInfo.eBoardKey}">
				<input type="hidden" id="fileNoDel" name="fileNoDel[]" value="">
				<input type="hidden" id="fileNameDel" name="fileNameDel[]" value="">
				
				<div class="content">
					<div class="content_tit">
						<h2>게시글 수정</h2>
					</div>
				</div>
				
				<div class="tbl_write">
					<table>
						<tbody id="lineRow">
							<tr>
								<th>번호</th>
								<td>
									<c:out value="${boardInfo.eBoardNo}"/>
								</td>
							</tr>
							<tr>
								<th>글 제목</th>
								<td>
									<input type="text" id="eBoardTitle" name="eBoardTitle"  value="${boardInfo.eBoardTitle}">
								</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>
									<c:out value="${boardInfo.kUserName}"/>    
								</td>
							</tr>
							<tr>
								<th>작성일자</th>
								<td>
									<c:out value="${boardInfo.eBoardDate}"/>
								</td>
							</tr>
							<tr>
								<th>내용</th>
								<td>
									<textarea id="eBoardContent" name="eBoardContent">${boardInfo.eBoardContent}</textarea>
								</td>
							</tr>
							<tr>
								<td>
 									<a href="#" class="btn" onclick="add_file()">파일추가</a>
								</td>
							</tr>
							<c:forEach var="file" items="${file}" varStatus="i">
								<tr>
									<td>
										<input type="text" id="fileKey" name="fileKey" value="${file.file_key}">
										<a class="del" id="fileDel" onclick="fn_del('${file.file_key}','file_no_${i.index}',this);">X</a><br>
									</td>
									<td>
										<input type="text" id="file_no" name="file_no_${i.index}" value="${file.file_key}">
										<input type="text" id="file_name" name="file_name" value="file_no_${i.index}">
										<a href="#" id="fileName" onclick="fn_fileDown('${file.file_key}');">${file.org_file_name}</a>(${file.file_size})<br/>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<div class="tbl_btn">
					<ul>
						<li>
							<a href="#" class="btn" onclick="update_go()">수정</a>
						</li>
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
