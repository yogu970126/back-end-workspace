<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>1~50까지의 합산 결과 값 1) 기존 방식</h2>
	
	<p>request : <%= request.getAttribute("result") %></p>
	<p>session : <%= session.getAttribute("result") %></p>
	
	<%--
		EL
		- Attribute에 바인딩된 값을 찾아오는 로직을 태그로 바꾼 기술
		- 객체를 바인딩한 ${이름} 이 사용된다.
		- request의 경우 Scope 무시하고 작성 가능, session인 경우 Scope 명시 필요
	 --%>
	<h2>1~50까지의 합산 결과 값 2) EL</h2>
	<p>request : ${requestScope.result}</p>
	<p>session : ${sessionScope.result}</p>
	<p>request : ${result}</p>
	
</body>
</html>