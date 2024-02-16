package com.kh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 공장 기계 역할! 프레스 틀 같은 존재
public interface Controller {
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	
}
