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
		
		$("#scoreInputBtn").click(function(){
			if($("#testName").val()==""){
				alert("시험명이 비었습니다");
				return;
			}
			$("#addScoreForm").attr({
				"method": "post",
				"action": "<c:url value="/lecture/inputScore"/>"
			}).submit();
		});
	});
</script>
</head>
<body>
	<form id="addScoreForm" name="addScoreForm">
		<input type="hidden" value="${lectureId}" id="lectureId" name="lectureId">
		시험명 : <input type="text" name="testName" id="testName">
		<table>
			<tr>
				<td>이름</td>
				<td>성적입력</td>
			</tr>
			<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.userName}</td> 
						<td><input type="text" class="score" name="score" style="width: 30px;"> 점</td>
					</tr>
			</c:forEach>
		</table>	
	</form>
	<input type="button" id="scoreInputBtn" value="점수등록">
</body>
</html>
