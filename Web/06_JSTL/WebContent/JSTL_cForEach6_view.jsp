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
	<!-- index : 0부터, count : 1부터 -->
	<ul>
		<c:forEach items="${arr}" var="menu" varStatus="status">
			<li>${status.count} ${menu}</li>
		</c:forEach>
	</ul>
	
		<ul>
		<c:forEach items="${arr}" var="menu" varStatus="status">
			<li>${status.index} ${menu}</li>
		</c:forEach>
	</ul>
</body>
</html>