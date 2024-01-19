package com.kh.example.practice4.controller;

import com.kh.example.practice4.model.Rectangle;

public class RectangleController {
	private Rectangle r = new Rectangle();
	
	public String calcRectArea(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		
		return "위치 : (" + x + "," + y + "), 너비 : " + width + ", 높이 : " + height +
							" / 면적 : " + width * height;
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		
		return "위치 : (" + x + "," + y + "), 너비 : " + width + ", 높이 : " + height +
							" / 둘레 : " + (width + height) * 2;
	}

}
