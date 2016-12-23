<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
		
		$("#teams").on("click", ".team", function() {
			var id = $(this).data("id");
			var teams = $(this);
			
			if(teams.find(".members").text() == ""){
				$.post("<c:url value="/projects/teams/users/"/>" + id, function(data) {
					console.log(data);
					
					for(var i in data) {
						var member = $("<div class='member'></div>");
						if(data[i] != null) {
							member.append($("<div>"+data[i].id+"</div>"));
						}
						teams.find(".members").append(member);
					}
				});
			}else{
				teams.find(".members").html("");
			}

			
		});
		
	});
	
		function deleteTeam(teamId){
			if(confirm("정말 삭제하시겠습니까?")){
				$.post("<c:url value="/projects/teams/delete/"/>"+teamId, function(data){
					$("#"+data).remove();
				});
			}
		}
	
	
				
</script>
<style type="text/css">
	#teams .teamName, .totalNumber, .createdDate {
		display: inline-block;
		width: 15em;
	}
</style>
</head>
<body>
	<div id="teams">
		<div>
			<span class="teamName">팀명</span>
			<span class="totalNumber">인원수</span>
			<span class="createdDate">생성일</span>
		</div>
		
		<c:choose>
			<c:when test="${ not empty teamsList.pageList }">
				<c:forEach items="${teamsList.pageList}" var="teams">
					<div class="team" data-id="${teams.id }" id="${teams.id }">
						<span class="teamName">${teams.teamName }</span>
						<span class="totalNumber">${fn:length(teams.user) }</span>
						<span class="createdDate">${teams.createdDate }</span>
						<span class="modify"><a href="<c:url value="/projects/teams/modify/${teams.id }"/>">수정</a></span>
						<span class="delete"><a href="javascript:void(0)" onclick="deleteTeam('${teams.id}')">삭제</a></span>
						<div class="members"></div>
					</div>			
				</c:forEach>
				
			</c:when>
			<c:otherwise>
				<div>
					<span>조회된 데이터가 없습니다.</span>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	
	<form id="searchForm">
		${page}
	</form>
	
	<a href="<c:url value="/projects/teams/addTeam/${lectureId }"/>">팀 생성</a>

</body>
</html>