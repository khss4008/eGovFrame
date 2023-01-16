<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/myproject_new/script/jquery-1.12.4.js"></script>
<script src="/myproject_new/script/jquery-ui.js"></script>

</head>

<script>

$(function(){
	
	$("#delBtn").click(function(){
		
		var pass = $("#pass").val();
		pass = $.trim(pass);
		if(pass ==""){
			alert("암호를 입력해주세요.");
			$("#pass").focus();
			return false;
		}
	});
	
});

</script>



<body>
	
	<table>
	
	<tr>
		<th>암호입력</th>
		<td><input type="password" id="pass"></td>
		<td><button type="button" id="delBtn">삭제</button></td>
	</tr>
	
	</table>
	
</body>
</html>