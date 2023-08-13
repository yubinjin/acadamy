<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<c:choose>
		<c:when test="${members.isEmpty() == false }" >
			<table border = 1>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>이메일</th>
				</tr>
					<c:forEach var="member" items="${members }">
						<tr>
							<td>${member.getId() }</td>
							<td>${member.pw }</td>
							<td>${member.name }</td>
							<td>${member.email }</td>
						</tr>
					</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h3>등록된 데이터 없습니다</h3>
		</c:otherwise>
	</c:choose>
	
	<a href="index">인덱스 페이지로 이동</a>
</body>
</html>






