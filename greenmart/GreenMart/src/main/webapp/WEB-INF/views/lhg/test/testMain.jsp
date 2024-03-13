<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="resources/css/main.css">
</head>
<body>
<script>

function insert(){
	document.frm.action = "/mainTest_I";
	document.frm.submit();
}
</script>

<form name="frm" method="get">
	<h3>Hello</h3>
	
	<a onclick="insert();">test</a>

</form>
</body>
</html>