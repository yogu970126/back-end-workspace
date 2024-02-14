package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/FindMemberServlet")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 폼 값 받기
		String id = request.getParameter("id");
		// 2. DAO 작성
		MemberDAO dao = new MemberDAO();
		Member member = null;
		try {
			member = dao.findMember(id);
			
			if(member!= null) {
				// 3. 데이터 바인딩
				request.setAttribute("searchmember", member);
				
				// 4. 네비게이션
				request.getRequestDispatcher("views/find_ok.jsp").forward(request, response);
			} else {
				response.sendRedirect("views/find_fail.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
