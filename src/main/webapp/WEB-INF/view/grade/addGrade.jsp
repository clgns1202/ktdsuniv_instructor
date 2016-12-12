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
		$("#gradeInputBtn").click(function(){
			if($("#testName").val() == ""){
				alert("테스트명을 입력하세요");
				return;
			}
			if($("#score").val() ==""){
				alert("점수을 입력하세요");
				return;
			}
			$("#addGradeForm").attr({
				"method" : "post",
				"action" : "<c:url value="/grade/doAddGrade"/>"
			}).submit();			
		});
	});
</script>
</head>
<body>
	<form id="addGradeForm" name="addGradeForm">
		학생 :	<select	id="userId" name="userId">
					<c:forEach items="${userList}" var="user">
						<option value="${user.id}">${user.userName}</option>
					</c:forEach>
				</select><br/>
		시험 :	<input type="text" id="testName" name="testName"><br/>
		점수 :	<input type="text" id="score" name="score" style="width: 30px;"><br/>
		<input type="hidden" value="${lectureId}" id="lectureId" name="lectureId">
	</form>
	<input type="button" value="성적입력" id="gradeInputBtn">
</body>
</html>