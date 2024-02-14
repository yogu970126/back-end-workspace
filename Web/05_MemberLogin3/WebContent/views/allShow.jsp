<%@page import="com.kh.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 회원 조회</title>
</head>
<body>
	<h1>회원 목록 출력</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		<% ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list"); 
			for(Member m : list) {
		%>
		<tr>
			<td><%= m.getId() %></td>
			<td><%= m.getPassword() %></td>
			<td><%= m.getName() %></td>		
		</tr>
		<% } %>
	</table>
	
	<a href="index.jsp">메인 페이지로</a>
</body>
</html>