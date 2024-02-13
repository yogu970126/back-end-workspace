<%@page import="com.kh.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 내 풀이
	<h1> 조회한 멤버 정보 </h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		<% 
			ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list"); 
			for(Member m : list) {
		%>
		<tr>
			<td><%= m.getId() %></td>
			<td><%= m.getPassword() %></td>
			<td><%= m.getName() %></td>
		</tr>
		<% 
			}
		%>
	</table>
	--%>
	
	<%-- 강사님 풀이 --%>
	<% Member info = (Member)request.getAttribute("info"); %>
	<h1>회원 정보 결과</h1>
	<ul>
		<li>아이디 : <%=info.getId() %></li>
		<li>비밀번호 : <%=info.getPassword() %></li>
		<li>이름 : <%=info.getName() %></li>
	</ul>
</body>
</html>











