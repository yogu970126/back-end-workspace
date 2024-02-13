<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h1>회원 관리 기능</h1>

    <ul>
    	<%-- 로그인 되어 있지 않는 경우 --%>
    	<li><a href="views/register.html">회원가입</a></li>
    	<%-- 회원가입 : 아이디, 비밀번호, 이름 입력 받아서
    		-> RegisterServlet / post 방식	
    		-> index.jsp로 이동
    	 --%>
    	 
    	<li><a href="views/login.html">로그인</a></li>
    	<%-- 
    		로그인 : 아이디, 비밀번호 입력 받아서
    		 -> LoginServlet / post 방식
    		 -> 세션 데이터 바인딩
    		 -> views/login_result.jsp로 이동해서 정보 출력
    	--%>
    	
    	<%-- 로그인 된 경우 --%>
    	<li><a href="views/search.html">회원검색</a></li>
    	<%-- 회원검색 : 검색할 아이디를 입력받아서
    		FindMemberServlet / GET 
    		성공하면 views/find_ok.jsp로 이동해서 정보 출력
    		실패하면 views/find_fail.jsp로 이동
    	--%>
    		 
    	<li><a href="AllMemberServlet">전체회원보기</a></li>
    	<%-- 전체회원보기 : views.allShow.jsp에 전체 리스트 출력 --%>
    	
    	<li><a href="LogoutServlet">로그아웃</a></li>
    	<%-- 로그아웃 : 로그아웃하고 index.jsp로 오면 됨 --%>
    	
    </ul>
  </body>
</html>
