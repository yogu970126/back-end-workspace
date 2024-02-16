package com.kh.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.vo.Member;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 3. 세션 죽이기
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("logininfo");
		if(member!=null) {
			session.invalidate();
		}
		
		return new ModelAndView("/index.jsp", true);
	}

}
