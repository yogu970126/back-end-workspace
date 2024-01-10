package com.kh.operator;

public class A_LogicalNegation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 논리 부정 연산자
		 * 
		 * !논리값(true, false)
		 * 
		 * - 논리값을 반대로 바꾸는 연산자 (true > false, false > true)
		 * 
		 * */
		boolean b1 = true;
		boolean b2 = false;
		
		// syso 하고 ctrl+space 하면 자동완성
		System.out.println("b1 부정 : " + !b1); // false
		
		// 실행 단축키 : ctrl + f11
		System.out.println("b2 부정 : " + !b2); // true
		
		b1 = !b2;
		System.out.println(!!b1); // true
		
		
	}

}
