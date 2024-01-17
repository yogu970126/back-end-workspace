package com.kh.example.practice2.controller;

import com.kh.example.practice2.model.Snack;

public class SnackController {
	
	private Snack s = new Snack();
	
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		System.out.println(kind + ", " + name + ", " + flavor + ", " + numOf + ", " + price);
		
	s.setKind(kind);
	s.setName(name);
	s.setFlavor(flavor);
	s.setNumOf(numOf);
	s.setPrice(price);
			
		return "저장 완료 되었습니다.";
	}
	
	public String confirmData() {
		return s.getKind() + "(" + s.getName()
					+ " - " + s.getFlavor() + ") "
					+ s.getNumOf() + "개 " + s.getPrice() + "원";
		}
}

/*
 * Model : DB, Table 등등
 * 
 * View : 화면
 * 
 * Controller : 기능 개발
 *
 */