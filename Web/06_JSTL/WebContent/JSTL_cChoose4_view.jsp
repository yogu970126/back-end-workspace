<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 비교문에서 == 대신 eq 사용 가능 -->
	<c:choose>
		<c:when test="${param.num == '1'}">
			곤니치와
		</c:when>
		<c:when test="${param.num eq '2'}">
			왈랄랄랄랄랄랄랄루
		</c:when>
		<c:otherwise>
			???
		</c:otherwise>
	</c:choose>
</body>
</html>