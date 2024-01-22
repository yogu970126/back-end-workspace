package com.kh.practice;

import java.util.Scanner;

import com.kh.array.practice2.model.Member;
import com.kh.practice.controller.LibraryController;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	LibraryController lc = new LibraryController();

	public static void main(String[] args) {
		
		Application app = new Application();
		app.mainMenu();

	}
	
	public void mainMenu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.println("==== 메뉴 ====");
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 대여하기");
		System.out.println("3. 프로그램 종료하기");
		System.out.print("메뉴 번호 : ");
		
		
		
		while(true) {
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				myPage();
				break;
//			case 2:
//				rentalMenu();
//				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				return;
				}
		}
	}
	
	public void myPage() {
	
	}
	

	

}
