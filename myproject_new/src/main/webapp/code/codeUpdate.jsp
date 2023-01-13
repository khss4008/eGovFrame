<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<form name="frm" method="post" action="codeUpdateSave.do">
		
		<table>

			<td><input type="hidden" name="code" value=${resultDetail.code } readonly></td>

		
		<tr>
			<th>코드id</th>
			
			<td>
				<select name="gid">
					<option value="1" <c:if test=${resultDetail.gid == '1' }> selected </c:if>>Job(업무)</option>
					<option value="2" <c:if test=${resultDetail.gid == '2' }> selected </c:if>>Hobby(취미)</option>
					
				</select>

			</td>
		</tr>
	
		<tr>
			<th>코드이름</th>
			<td><input type="text" name="name" value=${resultDetail.name }></td>
		</tr>
		
		<tr>
			<th colspan="2">
			<button type="submit">저장</button>
			<button type="reset">취소</button>
			</th>	
		</tr>
	</table>
	
	</form>

</body>
</html>