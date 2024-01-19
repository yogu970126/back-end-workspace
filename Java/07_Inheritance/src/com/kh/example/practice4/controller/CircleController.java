package com.kh.example.practice4.controller;

import com.kh.example.practice4.model.Circle;

public class CircleController {
	private Circle c = new Circle();

	public String calcArea(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);

		return "위치 : (" + x + "," + y + "), 반지름 : " + radius + " / 면적 : " + Math.PI * radius * radius;
	}

	public String calcCircum(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		
		return "위치 : (" + x + "," + y + "), 반지름 : " + radius + " / 둘레 : " + Math.PI * radius * 2;
	}
	

}
