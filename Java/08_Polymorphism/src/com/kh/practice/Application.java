package com.kh.practice;

import java.util.Scanner;

import com.kh.array.practice2.model.Member;
import com.kh.practice.controller.LibraryController;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	LibraryController lc = new LibraryController();
	Member m = new Member();

	
	public static void main(String[] args) {

		
		Application app = new Application();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		m.setName(name);
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		m.setAge(age);
		
		app.mainMenu();
		

	}
	
	public void mainMenu() {

		
		System.out.println("==== 메뉴 ====");
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 대여하기");
		System.out.println("3. 프로그램 종료하기");
		System.out.print("메뉴 번호 : ");
		
		boolean check = true;
		
		while(check) {
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				myPage();
				break;
			case 2:
				rentalMenu();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				check = false;
				return;
				}
		}
	}
	
	public void myPage() {
		
		System.out.println(m.toString());
		mainMenu();
	}
	
	public void rentalMenu() {
		System.out.print("0번 도서 : ");
		
		System.out.print("1번 도서 : ");
		
		System.out.print("2번 도서 : ");
		
		System.out.print("3번 도서 : ");
		
		System.out.print("대여할 도서 번호 선택 : ");
		int bookNum = Integer.parseInt(sc.nextLine());
	}
	

	

}
