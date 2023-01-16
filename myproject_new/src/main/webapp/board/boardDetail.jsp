<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세화면</title>
</head>

<style>

	table{
		width:400px;
		border-collapse:collapse; /*  cell 사이의 간격 없앰	*/
	}
	
	th, td{
		border:1px solid #cccccc;
		padding:5px;
	}
</style>

<body>
	<table>
		<tr>
			<th>제목</th>
			<td>${data.title }</td>
		</tr>
		
		<tr>
			<th>글쓴이</th>
			<td>${data.name }</td>
		</tr>
	
		<tr>
			<th>내용</th>
			<td height="50">${data.content }</td>
		</tr>

		<tr>
			<th>조회수</th>
			<td>${data.hits }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${data.rdate }</td>
		</tr>
		
		<tr>
			<th colspan="2">
			<button type="button" onclick="location='boardList.do'">목록</button>
			<button type="button" onclick="location='boardModifyWrite.do?unq=${data.unq}'">수정</button>
			<button type="button" onclick="location='passWrite.do?unq=${data.unq}'">삭제</button>
			</th>	
		</tr>
	</table>
</body>

</html>