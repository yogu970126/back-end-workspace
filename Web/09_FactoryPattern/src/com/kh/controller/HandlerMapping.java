package com.kh.controller;

import com.kh.controller.component.AllShowController;
import com.kh.controller.component.LoginController;
import com.kh.controller.component.LogoutController;
import com.kh.controller.component.RegisterController;
import com.kh.controller.component.SearchController;

// Controller의 공장 역할!
public class HandlerMapping {
	
	// 싱글톤 패턴 - 특정 클래스 객체가 오직 한개만 존재하도록 하기 위해서
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	// controller 생성!
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("register.do")) {
			controller = new RegisterController();
		} else if(command.equals("login.do")) {
			controller = new LoginController();
		} else if(command.equals("search.do")) {
			controller = new SearchController();
		} else if(command.equals("allShow.do")) {
			controller = new AllShowController();
		} else if(command.equals("logout.do")) {
			controller = new LogoutController();
		}
		
		return controller;
	}
	
}
