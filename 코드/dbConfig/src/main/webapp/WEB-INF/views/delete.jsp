<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
</head>
<body>
	<c:url var="contextRoot" value="/index" />
	<h3> ${msg } </h3>
	<form action="delete" method="post">
		<input type="text" readonly="readonly" value="${sessionScope.id }" /><br>
		<input type="password" name="pw" placeholder="비밀번호" /><br>
		<input type="password" name="confirm" placeholder="비밀번호 확인" /><br>
		<input type="submit" value="회원 탈퇴" />
		<input type="button" value="취소" onclick="location.href='${contextRoot }'" />
	</form>
</body>
</html>














