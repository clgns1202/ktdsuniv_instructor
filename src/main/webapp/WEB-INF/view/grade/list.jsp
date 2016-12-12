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

</script>
</head>
<body>
	<c:forEach items="${gradeList}" var="grade">
		<c:forEach items="${grade.score}" var="score">
			학생이름 : ${score.user.userName}<br/>
			<c:forEach items="${score.test}" var="test">
				시험명   ${test.testName} : 점수  ${test.score}
			</c:forEach><br/>
		</c:forEach> 
	</c:forEach>	
</body>
</html>