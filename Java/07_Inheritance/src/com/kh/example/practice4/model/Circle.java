package com.kh.example.practice4.model;

public class Circle extends Point{
	private int radius;
	
	public Circle() {}

	public Circle(int x, int y, int raduis) {
		super(x, y);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return super.toString() + " / Circle [radius=" + radius + "]";
	}
	
	
	

}
