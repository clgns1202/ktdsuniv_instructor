<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	
</script>
</head>
<body>

	
	<h1>${lecture.lectureName}</h1>
	<hr/>
	<a href="<c:url value="/lecture/userDetail/${lecture.id}"/>">수강생 정보</a>
	<a href="<c:url value="/lecture/userDetail/${lecture.id}"/>">성적 관리</a>
	<a href="<c:url value="/lecture/userDetail/${lecture.id}"/>">프로젝트/팀</a>
	<a href="<c:url value="/lecture/userDetail/${lecture.id}"/>">과제 게시판</a>
	<a href="<c:url value="/lecture/userDetail/${lecture.id}"/>">Q&A</a>
	<a href="<c:url value="/lecture/userDetail/${lecture.id}"/>">동영상강의</a>
		
	<hr/>
	<h5>강사: ${lecture.instructor.user.userName}</h5>
	<h5>관리자: ${lecture.admin.user.userName}</h5>
	<h5>호실: ${lecture.room.roomNumber}</h5>
	<h5>기간: ${lecture.startDate} - ${lecture.endDate} </h5>
	<h5>강의시간: ${lecture.startTime} - ${lecture.endTime}</h5>
	<hr/>
	<h4>강의내용</h4>
	<h3>${lecture.lectureContent}</h3>
	<hr/>

	
</body>
</html>