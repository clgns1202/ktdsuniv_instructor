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
		$("#logoutBtn").click(function() {
			location.href="<c:url value="/instructor/instructorSignOut" />";
		});
		
	});
</script>
</head>
<body>
	강사 메인페이지
	<c:forEach items="${lectures}" var="lecture">
		<table>
			<tr>
				<td>강의 이름</td>
				<td>강의 기간</td>
				<td>강사 이름</td>
			</tr>
			<tr>
				<td><a href="<c:url value="/lecture/detail/${lecture.id}"/>">${lecture.lectureName}</a></td>
				<td>${lecture.startDate}-${lecture.endDate}</td>
				<td>${lecture.instructor.user.userName}</td>
			</tr>
		
		</table>

	</c:forEach>
	
	
	<input type="button" value="로그아웃" name="logoutBtn" id="logoutBtn"/> 
</body>
</html>