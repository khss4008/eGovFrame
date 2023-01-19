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
	
	.div1{
	
		width:400px;
		text-align:left;
		font-size:11pt;
	
	}
	.div2{
	
		width:400px;
		text-align:left;
		font-size:8pt;
	
	}
	.name{
	font-size:15pt;
	}
</style>
<body>
	<%@include file="../include/topmenu.jsp" %>
		<div class=div1>
			<div class=name>일반게시판 목록</div>
			<div>Total : ${total }</div>
		</div>
	<div class=div2>
	
	<form name="searchFrm" method="post" action="boardList.do">
	
	<select name="searchGubun" id="searchGubun">
		<option value="title">제목</option>
		<option value="name">글쓴이</option>
		<option value="content">내용</option>
	</select>
	<input type="text" name="searchText" id="searchText">
	<button type="submit">검색</button>
	
	</form>
	
	</div>
	
	<table>
		

		
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
		<c:set var="cnt" value="${rowNumber }" />
		<c:forEach var="a" items="${resultList}">
		<tr align="center">
			<td>${cnt }</td>
			<td><a href="boardDetail.do?unq=${a.unq}">${a.title }</a></td>
			<td>${a.name }</td>
			<td>${a.rdate }</td>
			<td>${a.hits }</td>
		</tr>	
			</td>		
			<c:set var="cnt" value="${cnt-1 }"/>
		</c:forEach>
	</table>
	
	<div style="width:400px;margin-top:5px; text-align:center">
		<c:forEach var="i" begin="1" end="${totalPage }">
			
			<a href="boardList.do?viewPage=${i }">${i }</a> 
			
		</c:forEach>
	</div>

	<div style="width:400px;margin-top:5px; text-align:right">
		<button type="button" onclick="location='boardWrite.do'">글쓰기</button>
	</div>
	
</body>
</html>