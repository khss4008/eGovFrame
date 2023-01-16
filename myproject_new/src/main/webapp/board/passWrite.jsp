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
		
		var sendData = "unq=${unq}&pass="+pass;
		
		$.ajax({ 
			
			type:"POST",
			data:sendData,		//json 설정
			url:"boardDelete.do",
			dataType:"text", 		//리턴 타입
			success: function(data){	// controller -> ok
				if(data == "1"){
					alert("삭제 완료");
					location="boardList.do";
				}else if(data == "-1"){
					alert("암호가 일치하지 않습니다.");
				}else{
					alert("삭제 실패 \n 관리자에게 문의해 주세요.")
				}
			}, 
			error: function(){		//장애 발생
				alert("오류발생");
			}
		});
		
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