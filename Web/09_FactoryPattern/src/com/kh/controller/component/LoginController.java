package com.kh.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class LoginController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		
		// 세션은 바인딩만 하고 굳이 포워드로 보낼 필요 없다
		return new ModelAndView("views/login_result.jsp", true);
	}

}
