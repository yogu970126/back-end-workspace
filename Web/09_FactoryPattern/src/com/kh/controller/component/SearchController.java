package com.kh.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class SearchController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 폼 값 받기
		String id = request.getParameter("id");
		// 2. DAO 작성
		MemberDAO dao = new MemberDAO();
		Member member = null;
	
		member = dao.findMember(id);
		// 삼항연산자 사용
		/*
		if(member!= null) request.setAttribute("searchmember", member);
		return member != null ? "views/find_ok.jsp" : "views/find_fail.jsp";
		*/
		
		if(member!= null) {
			// 3. 데이터 바인딩
			request.setAttribute("searchmember", member);
			return new ModelAndView("views/find_ok.jsp");
			} else {
			return new ModelAndView("views/find_fail.jsp" , true);
			} 
	}

}
