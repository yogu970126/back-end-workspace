package com.kh.practice3;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
	Scanner sc = new Scanner(System.in);
	
	String name = "";
	int age = 0;
	int coupon = 0;
	String[] bookList = new String[3];
	
	int num = -1;

	public static void main(String[] args) {
		// static 에서 기능구현 미추천
		
		Application app = new Application();
		app.mainMenu();
		
	}
	
	public void mainMenu() {
		
		
		System.out.print("이름 : ");
		name = sc.nextLine();
		
		System.out.print("나이 : ");
		age = Integer.parseInt(sc.nextLine());
		
		boolean check = true;

		
		// for문 : 범위가 정해져 있을 때
		// while문 : 무한루프나 조건 등을 걸 때
		while(check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int menu = Integer.parseInt(sc.nextLine());			
			
			switch(menu) {
			case 1 :
				myPage();
				break;
			case 2 :
				rentBook();
				break;
			case 3 :
				System.out.println("프로그램 종료");
				check = false;
				break;
			}
		}
	}
	
	public void myPage() {
		System.out.println("Member[name=" + name + ", age=" + age + 
				", cookCoupon=" + coupon + ", bookList=" + Arrays.toString(bookList) + "]");
	}
	
	public void rentBook() {
		System.out.println("0번 도서 : Book [title=맛있는 지중해식 레시피] / Cookbook [coupon=true]");
		System.out.println("1번 도서 : Book [title=카페 샌드위치 마스터 클래스] / Cookbook [coupon=false]");
		System.out.println("2번 도서 : Book [title=원피스 107] / AniBook [accessAge = 19]");
		System.out.println("3번 도서 : Book [title=주술회전 24] / AniBook [accessAge = 15]");
		System.out.print("대여할 도서번호 선택 : ");
		num = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < bookList.length; i++) {
			if(bookList[i] == null) {
				// 대여 가능 공간
				if(num == 0) {
					coupon++;
					bookList[i] = "Book [title=맛있는 지중해식 레시피] / Cookbook [coupon=true]";
				} else if(num == 1) {
					bookList[i] = "Book [title=카페 샌드위치 마스터 클래스] / Cookbook [coupon=false]";
				} else if(num == 2 && age >= 19) {
					bookList[i] = "Book [title=원피스 107] / AniBook [accessAge = 19]";
				} else if(num == 3 && age >= 15) {
					bookList[i] = "Book [title=주술회전 24] / AniBook [accessAge = 15]";
				} 
				break;
			}
		}
		
		if(num == 2 && age < 19 || num == 3 && age < 15) {
			System.out.println("나이 제한으로 대여 불가능입니다.");
		} else {
			System.out.println("성공적으로 대여되었습니다.");
		}
	}

}















