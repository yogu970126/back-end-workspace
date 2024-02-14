<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Member searchmember = (Member)request.getAttribute("searchmember"); %>
	<h1>회원 조회 결과</h1>
	<ul>
		<li>아이디 : <%=searchmember.getId() %></li>
		<li>비밀번호 : <%=searchmember.getPassword() %></li>
		<li>이름 : <%=searchmember.getName() %></li>
	</ul>
</body>
</html>