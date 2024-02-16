package com.kh.controller.component;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 폼 값 받아오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		

		// 2. DAO 작성
		MemberDAO dao = new MemberDAO();
		Member member = new Member(id, password, name);
		System.out.println(member);
		
		if(dao.registerMember(member)==1) {
			return new ModelAndView("index.jsp", true);
		} else {
			return new ModelAndView("views/register_fail.jsp");
		}
	}
	
}
