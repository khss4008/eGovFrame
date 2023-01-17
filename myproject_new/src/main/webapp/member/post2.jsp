<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<select name="address">
	
	<c:forEach var="i" items="${dongList}">
		<option value="${i.addr}">${i.addr}</option>
	</c:forEach>
	
</select>

</body>
</html>