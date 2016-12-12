<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="<c:url value="/projects/teams/doAddTeam"/>" method="post">
		<div><label for="lectureId">강의ID : </label><input type="text" name="lectureId" id="lectureId"></div>
		<div><label for="teamName">팀명 : </label><input type="text" name="teamName" id="teamName"></div>
		
		<div class="checkbox">
			<c:forEach varStatus="state" begin="1" end="10">
				<div><input type="checkbox" name="userId" id="userId${state.index }" value="userId${state.index }"/><label for="user${state.index }">user${state.index }</label></div>
			</c:forEach>
			
		</div>
		
		<div>
			<input type="submit" value="팀 생성"/>
		</div>
	</form>

</body>
</html>