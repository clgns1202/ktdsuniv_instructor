<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>수강자 정보</h3>
	<table border="1" style="border-collapse:collapse; border:1px gray solid; ">
	<tr>
		<td>이름</td>
		<td>생년월일</td>
		<td>성별</td>
		<td>주소</td>
		<td>전화번호</td>
	</tr>
	<tr>
		<c:forEach items="${lecture.user}" var="users">		
			<td>${users.userName}</td>
			<td>${users.birthday}</td>
			<td>${users.gender}</td>
			<td>${users.address}</td>
			<td>${users.phoneNumber}</td>
		</c:forEach>
	</tr>
	</table>
	
	
</body>
</html>