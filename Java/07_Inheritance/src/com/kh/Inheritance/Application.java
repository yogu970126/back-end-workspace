package com.kh.Inheritance;

import com.kh.Inheritance.child.Notebook;
import com.kh.Inheritance.child.Smartphone;
import com.kh.Inheritance.child.Tv;

public class Application {

	public static void main(String[] args) {
		Notebook notebook = new Notebook("애플", "mbp-14", "맥북 프로 14", 2390000, "M3");
		Smartphone phone = new Smartphone();
		phone.setBrand("삼성");
		phone.setpCode("SM-F946NZUAKOO");
		phone.setName("갤럭시 Z 폴드 5");
		phone.setPrice(2097700);
		phone.setMobileAgency("SKT");
		
		Tv tv = new Tv("엘지", "OLED97M3KNA", "시그니처 올레드", 45800000, 97);
		
		System.out.println(notebook);
		System.out.println(phone);
		System.out.println(tv);
		
	}

}
