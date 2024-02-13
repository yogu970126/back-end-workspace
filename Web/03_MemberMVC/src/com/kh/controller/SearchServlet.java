package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼 값 받아오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		/* 내 풀이
		// VO 작성
		Member member = new Member(id, password, name);
		
		// DAO 리턴 받기
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = null;
		try {
			list = dao.searchMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 바인딩
		request.setAttribute("list", list);
		
		// 네비게이션
		request.getRequestDispatcher("search.jsp").forward(request, response);
		*/
		
		// 강사님 풀이
		// DAO 리턴 받기
		MemberDAO dao = new MemberDAO();
		Member member = null;
		try {
			member = dao.searchMember(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 바인딩
		request.setAttribute("info", member);
		
		// 네비게이션 (만약에 멤버 정보가 없으면.. 이라는 것 추가!)
		if(member!= null) {
			request.getRequestDispatcher("search.jsp").forward(request, response);
		} else {
			response.sendRedirect("fail.jsp");
		}
	}
	

}
