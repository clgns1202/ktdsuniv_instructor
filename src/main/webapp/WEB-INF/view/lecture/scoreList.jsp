<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
		
	});
</script>
</head>
<body>
	<p>점수 목록</p>
	<hr>
	<table style="border:1px solid;">
		<tr>
			<td></td>
			<c:forEach items="${users[0].tests}" var="test">
			<c:if test="${lectureId eq test.lectureId}">
			<td><a href="<c:url value="/lecture/scoreModify?testName=${test.testName}&&lectureId=${test.lectureId}"/>">${test.testName}</a></td>
			</c:if>
			</c:forEach>
		</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.userName}</td>
			<c:forEach items="${user.tests}" var="test">
			<c:if test="${lectureId eq test.lectureId}">
				<td>${test.score}</td>
			</c:if>
			</c:forEach>
		</tr>
	</c:forEach>
	</table>
</body>
</html>