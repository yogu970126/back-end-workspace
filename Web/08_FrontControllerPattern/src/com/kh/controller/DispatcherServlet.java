package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청이 어디에서 들어오는 요청인지 구분할 command 값 같이 받는다.
		String command = request.getParameter("command");
		String path = "index.jsp";
		try {
			if(command.equals("register")) {
				path = register(request, response);
			} 
			else if(command.equals("login")) {
				path=login(request,response);
			}
			else if(command.equals("logout")) {
				path=logout(request,response);
			}
			else if(command.equals("findmember")) {
				path=findMember(request, response);
			}
			else if(command.equals("allShow")) {
				path=allMember(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected String register(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		// 1. 폼 값 받아오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		

		// 2. DAO 작성
		MemberDAO dao = new MemberDAO();
		Member member = new Member(id, password, name);

		dao.registerMember(member);

		return "index.jsp";
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// 1. 폼 값 받아오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DAO 작성
		Member member = new Member();
		MemberDAO dao = new MemberDAO();

		member = dao.login(id, password);
			
		// 3. 세션에 바인딩
		HttpSession session = request.getSession();
		session.setAttribute("logininfo", member);
			
		return "views/login_result.jsp";
	}
	
	protected String logout(HttpServletRequest request, HttpServletResponse response) {
		
		// 3. 세션 죽이기
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("logininfo");
		if(member!=null) {
			session.invalidate();
		}

		return "/index.jsp";
	}
	
	protected String findMember(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// 1. 폼 값 받기
		String id = request.getParameter("id");
		// 2. DAO 작성
		MemberDAO dao = new MemberDAO();
		Member member = null;
	
		member = dao.findMember(id);
		// 삼항연산자 사용
		if(member!= null) request.setAttribute("searchmember", member);
		return member != null ? "views/find_ok.jsp" : "views/find_fail.jsp";
		
		/*
		if(member!= null) {
			// 3. 데이터 바인딩
			request.setAttribute("searchmember", member);
			return "views/find_ok.jsp";
			} else {
			return "views/find_fail.jsp";
			} */
	}
	
	protected String allMember(HttpServletRequest request, HttpServletResponse response) {
		// 2. DAO 작성
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = new ArrayList<>();
		try {
			list = dao.allShowMember();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. 바인딩
		request.setAttribute("list", list);
		
		return "views/allShow.jsp";
	}
	
}
