package com.kh.test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean check = true;
		while(check) {
			System.out.print("문자열을 입력해주세요 : ");
			String str = sc.nextLine();
			if(str.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				check = false;
			} else {
				System.out.println(str.length() + "글자 입니다.");
			}
		}
		
	}

}



/*	
while(false) {
	System.out.print("문자열을 입력해주세요 : ");
	String str = sc.nextInt();
	if(str == "exit") {
		continue;
	} else {
		System.out.println(str.length() + "글자 입니다.");
	}
}
System.out.println("프로그램을 종료합니다."); */