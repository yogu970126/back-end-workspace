package com.kh.operator;

import java.util.Scanner;

public class F_Triple {
	
	Scanner sc = new Scanner(System.in);
	/*
	 * 삼항 연산자
	 * 조건식 ? 값1 : 값2;
	 * 
	 * - 조건식에는 주로 비교, 논리 연산자가 사용된다.
	 * - 조건식의 결과가 true이면 값1을 수행한다.
	 * - 조건식의 결과가 false이면 값2를 수행한다.
	 * */

	public static void main(String[] args) {
		F_Triple f = new F_Triple();
		//f.method1();
		//f.practice1();
		//f.practice2();
		f.practice3();
	}
	
	// void : 리턴이 없는 클래스로 지정
	public void method1() {
	//	int num1 = 1;
	//	String result = "양수";
		
		
		// 입력받은 정수가 양수인지 음수인지 판단
		System.out.print("숫자를 입력하세요 > ");
		int num1 = sc.nextInt();
		
		// result = num1 >= 1 ? "양수" : "음수";
		String result = num1 >= 1 ? "양수" : num1 == 0 ? "0": "음수";
		System.out.printf("%d는 " + result + " 입니다.", num1);
	}
	/*
	 * 실습 문제 1
	 * 
	 * 사용자한테 두 개의 정수값을 입력받아서 두 정수의 곱셈 결과가 100보다 크거나 같은 경우
	 * "결과가 100 이상이비다." 아닌 경우 "결과가 100보다 작습니다." 출력
	 */
	public void practice1() {
		System.out.print("첫 번째 값을 입력하시오 > ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 값을 입력하시오 > ");
		int num2 = sc.nextInt();
		
		String result = num1 * num2 >= 100 ? "결과가 100 이상입니다." : "결과가 100보다 작습니다.";
		System.out.println(result);
	}
	/*
	 * 실습 문제 2
	 * 
	 * 사용자한테 문자를 하나 입력받아서 입력한 문자가 대문자이면 
	 * "알파벳 대문자이다." 아닌 경우 "알파벳 대문자가 아니다." 출력
	 */
	public void practice2() {
		char alp = '\u0000';
		System.out.print("알파벳을 입력하시오 > ");
		alp = sc.nextLine().charAt(0);
		
		String result = alp >= 65 && alp <= 90 ? "알파벳 대문자이다." : "알파벳 대문자가 아니다.";
		System.out.println(result);
		
	}
	
	/*
	 * 실습 문제 3
	 * 
	 * 두 정수를 입력받고 + 또는 -를 입력 받아서 계산을 출력
	 * 단, + 또는 - 이외의 문자를 입력하는 경우 "잘못 입력했습니다." 출력
	 * 
	 * 예시)
	 * 첫 번째 수 > 3
	 * 두 번째 수 > 4
	 * 
	 * 연산자 입력(+ 또는 -) > +
	 * 3 + 4 = 7
	 * 
	 * 연산자 입력(+ 또는 -) > -
	 * 3 - 4 = -1
	 * 
	 * 연산자 입력(+ 또는 -) > *
	 * 잘못 입력했습니다.
	 */
	public void practice3() {
		System.out.print("첫 번째 수 > ");
		// String -> int : Integer.parseInt
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("두 번째 수 > ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		char op = '\u0000';
		System.out.print("연산자 입력(+ 또는 -) > ");
		op = sc.nextLine().charAt(0);
	    
	    String result = op == '+' ? num1 + " + " +  num2 + " = " + (num1 + num2)
	    			  : op == '-' ? String.format("%d - $d = %d, num1, num2, (num1-num2)")
	    			  :"잘못 입력했습니다.";
	    
		System.out.println(result); 
		
		// 또 다른 방법
	/*	if(op == '+' || op == '-') {
			System.out.printf("%d %c %d = %d", num1, op, num2, 
					op == '+' ? (num1+num2) : (num1-num2));
		} else {
			System.out.println("잘못 입력했습니다.");
		} */

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
