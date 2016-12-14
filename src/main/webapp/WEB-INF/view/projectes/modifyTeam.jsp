<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
		
		$.post("<c:url value="/projects/teams/users/${team.id}"/>", function(data){
			for(var i in data){
				$("#"+data[i].id).prop('checked', true);
			}
		});
		
	});
</script>
</head>
<body>

	<form action="<c:url value="/projects/teams/doModifyTeam"/>" method="post">
		<input type="hidden" id="id" name="id" value="${team.id }"/>
		<div><label for="lectureId">강의ID : </label><input type="text" name="lectureId" id="lectureId" value="${team.lectureId }"></div>
		<div><label for="teamName">팀명 : </label><input type="text" name="teamName" id="teamName" value="${team.teamName }"></div>
		
		<div class="checkbox">
			<c:forEach varStatus="state" begin="1" end="10">
				<div><input type="checkbox" name="userId" id="userId${state.index }" value="userId${state.index }"/><label for="user${state.index }">user${state.index }</label></div>
			</c:forEach>
			
		</div>
		
		<div>
			<input type="submit" value="팀 수정"/>
		</div>
	</form>

</body>
</html>