package com.lee.practice1.controller;

import com.lee.practice1.model.Snack;

public class SnackController {
	
	private Snack s = new Snack();
	
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
				
		return "저장 완료되엇습니다.";
	}
	
	public String confirmData() {
		return s.getKind() + "(" + s.getName() + " - " + s.getFlavor() 
					+ ") " + s.getNumOf() + "개 " + s.getPrice() + "원";
	}

}
