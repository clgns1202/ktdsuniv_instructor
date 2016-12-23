<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<title>Insert title here</title>
</head>
<body>
${test.userId }
${test.userName }

${test.birthday }

<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
		</tr>
		<c:choose>
			<%-- IF --%>
			<c:when test="${ not empty list.pageList }">
				<c:forEach items="${list.pageList}" var="user">
					<tr>
						<td>${user.userId}</td>
						<td>${user.userName }</td>
					</tr>				
				</c:forEach>
				
			</c:when>
			<%-- ELSE --%>
			<c:otherwise>
				<tr>
					<td colspan="6">조회된 데이터가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<form id="searchForm">
		${page}
		<select name="searchType" id="searchType">
			<option value="1" ${boardSearchVO.searchType eq 1 ? "selected" : "" }>제목</option>
			<option value="2" ${boardSearchVO.searchType eq 2 ? "selected" : "" }>작성자</option>
		</select>
		<input type="text" name="searchKeyword" id="searchKeyword" value="${boardSearchVO.searchKeyword}"/>
		<input type="button" id="searchBtn" value="검색" onclick="movePage(0)" />
	</form>



</body>
</html>