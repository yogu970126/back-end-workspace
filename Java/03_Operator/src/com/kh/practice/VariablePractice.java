package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		VariablePractice vp = new VariablePractice();
		vp.method1();
		//vp.method2();
		//vp.method3();
		

	}
	public void method1() {
	/*	영화관의 요금표는 다음과 같습니다.
		- 성인 : 10000원
		- 청소년 : 7000원
		성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요. */
		
		int adult = 2;
		int teen = 3;
		int adultprice = 10000;
		int teenprice = 7000;
		
		System.out.printf("성인 %d명 : %d원", adult, adultprice*adult);
		System.out.println();
		System.out.printf("청소년 %d명 : %d원", teen, teenprice*teen);
		System.out.println();
		System.out.printf("총 금액 : %d", (adultprice*adult)+(teenprice*teen));
		
	}
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		x = 7;
		y = 9;
		z = 5;
		
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);	
	}
	public void method3() {
	// 영어 문자열 값을 키보드로 입력 받아 문자에서 첫번째 글자와 마지막 글자를 출력하세요.
		System.out.print("문자열을 입력하세요 : ");
		String word = sc.nextLine();
		char wordfisrt = word.charAt(0);
		char wordlast = word.charAt(word.length()-1);
		System.out.println("첫번째 문자 : " + wordfisrt);
		System.out.println("마지째 문자 : " + wordlast);
	}
}
