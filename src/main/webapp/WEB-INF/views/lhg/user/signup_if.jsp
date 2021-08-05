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
function chkId(){
	var kUserId = $("#kUserId").val(); 
	console.log("kUserId : " + kUserId);
	$.ajax({
			type : "post",
			url	: "/lhg/user/chkId",
			dataType : "json",
			data : kUserId,
			success : function(msg){
				var resultFlag = msg.result.resultFlag;
				console.log("resultFlag : " + resultFlag);
				$("#kUserIdChk").val(resultFlag);
			},
			error : function(e){
			alert("에러발생");
		}
	})
}

function idChange(){
	$("kUserIdChk").val("F");
}

function signup_go(){
	
	if(chkIns()){
		document.frm.action = "/lhg/user/signup_i";
		document.frm.submit();
	}
}

//값이 비었는지 확인
function isEmpty(obj){
	if(obj == "" || obj == null || obj == undefined) return true;
	else return false;
}

//vali
function chkIns(){
	
	var frm = document.frm;
	
	if(isEmpty(frm.kUserId.value)){
		alert("아이디를 입력해주세요.");
		frm.kUserId.focus();
		return;
	}else if(frm.kUserIdChk.value.equals("F")){
		alret("아이디 중복확인 해주세요.");
	}
	
	if(isEmpty(frm.kUserPw.value)){
		alert("비밀번호를 입력해주세요.");
		frm.kUserPw.focus();
		return false;
	}else if(isEmpty(frm.kUserPwChk.value)){
		alert("비밀번호 확인을 입력해주세요.");
		frm.kUserPwChk.focus();
		return false;
	}else if(frm.kUserPw.value != frm.kUserPwChk.value){
		alert("비밀번호가 일치하지 않습니다.");
		frm.kUserPw.value.focus();
		return false;
	}
	
	if(isEmpty(frm.kUserName.value)){
		alert("이름을 입력해주세요.");
		$("#kUserName").focus();    
		return false;
	}
	
	if(isEmpy(frm.kUserMail.value)){
		alert("메일을 입력해주세요.");
		$("#kUserMail").focus();    
		return false;
	}
	
	if(isEmpy(frm.kUserPost.value)){
		alert("우편번호를 입력해주세요.");
		$("#kUserPost").focus();    
		return false;
	}
	
	if(isEmpy(frm.kUserAddr.value)){
		alert("도로명 주소를 입력해주세요.");
		$("#kUserAddr").focus();    
		return false;
	}
	
	if(isEmpy(frm.kUserAddrDetail.value)){
		alert("상세주소를 입력해주세요.");
		$("#kUserAddrDetail").focus();    
		return false;
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
			<form id="frm" name="frm" method="post" action="lhg/user/signup_i">
				<input type="hidden" id="kUserPass" name="kUserPass">
				
				<div class="content">
					<div class="content_tit">
						<h2>회원가입</h2>
					</div>
				</div>
				
				<div class="tbl_write">
					<table>
						<tbody>
							<tr>
								<th>아이디</th>
								<td>
									<input type="text" id="kUserId" name="kUserId" onchange="idChange()">
									<input type="hidden" id="kUserIdChk" name="kUserIdChk" value="F">
									<a href="javascript:void(0);" class="btn" onclick="chkId()">중복확인</a>
								</td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td><input type="password" id="kUserPw" name="kUserPw"></td>
							</tr>
							<tr>
								<th>비밀번호 확인</th>
								<td><input type="password" id="kUserPwCk" name="kUserPwCk"></td>
							</tr>
							<tr>
								<th>이름</th>
								<td><input type="text" id="kUserName" name="kUserName"></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td><input type="text" id="kUserMail" name="kUserMail" placeholder="email@email.com"></td>
							</tr>
							<tr>
								<th>주소</th>
								<td>
										<input type="text" id="kUserPost" placeholder="우편번호">
										<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
										<input type="text" id="kUserAddr" placeholder="도로명주소">
										<input type="text" id="kUserAddrDetail" placeholder="상세주소">    
								</td>
							</tr>
						</tbody>
					</table>
					<a href="javascript:void(0);" class="btn" onclick="signup_go()">가입하기</a>
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

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('kUserPost').value = data.zonecode;
                document.getElementById("kUserAddr").value = roadAddr;
            }
        }).open();
    }
</script>

</body>
</html>
