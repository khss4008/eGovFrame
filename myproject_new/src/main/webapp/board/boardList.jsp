<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	
		<caption>
		<div>코드목록</div><br>
		</caption>
		<colgroup>
			<col witdth="20%"/>
			<col witdth="20%"/>
			<col witdth="20%"/>
			<col witdth="20%"/>
			<col witdth="20%"/>
		</colgroup>
		
		<tr>
			<th width="20%">번호</th>
			<th width="20%">제목</th>
			<th width="20%">글쓴이</th>
			<th width="20%">등록일</th>
			<th width="20%">조회수</th>
		</tr>
		<c:forEach var="a" items="${resultList}">
		<tr align="center">
			<td>${a.unq }</td>
			<td>${a.title }</td>
			<td>${a.name }</td>
			<td>${a.rdate }</td>
			<td>${a.hits }</td>
		</tr>	
			</td>		
		</c:forEach>
	</table>
	
	<div style="width:400px;margin-top:5px; text-align:right">
		<button type="button" onclick="location='boardWrite.do'">글쓰기</button>
	</div>
	
</body>
</html>