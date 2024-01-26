package com.lee.practice3.controller;

import com.lee.practice3.model.Circle;

public class CircleController {
	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		
		return "";
		
		}
}

