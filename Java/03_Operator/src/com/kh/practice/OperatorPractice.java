package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
    
    Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		OperatorPractice op = new OperatorPractice();
//		 op.method1();
		//op.method2();
		//op.method3();
		//op.method4();
//		op.method5();
		op.method6();
				
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 키보드로 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		int people = 0;
		int pencil = 0;
		
		System.out.print("인원 수 > ");
		people = sc.nextInt();
		System.out.print("연필 개수 > ");
		pencil = sc.nextInt();
		
		System.out.println("인당 연필 개수 : " + pencil / people);
		System.out.println("남은 연필 개수 : " + pencil % people);
	}
	
	//키보드로 입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		int num1 = 0;
		System.out.print("정수를 입력하세요 > ");
		num1 = sc.nextInt();
		
		System.out.println((num1 / 100) * 100);
	}
	
	//3개의 수를 키보드로 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		boolean result = false;
		
		System.out.print("첫 번째 수 > ");
		num1 = sc.nextInt();
		System.out.print("두 번째 수 > ");
		num2 = sc.nextInt();
		System.out.print("세 번째 수 > ");
		num3 = sc.nextInt();
		
		result = num1 == num2 && num2==num3;
		System.out.println(result);
	}
	
	//키보드로 입력 받은 하나의 정수가 짝수이면 “짝수다“, 짝수가 아니면 “홀수다“를 출력하세요.
	public void method4() {
		int num1 = 0;
		
		System.out.print("정수를 입력하세요 > ");
		num1 = sc.nextInt();
		
		String result = (num1 % 2) == 0 ? "짝수다" : "홀수다";
		System.out.println(result);
	}
	
	//나이를 키보드로 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 성인(19세 초과)인지 출력하세요.
	public void method5() {
		int age = 0;
		
		System.out.print("나이를 입력하세요 > ");
		age = sc.nextInt();
		
		String result = age > 19 ? "성인" : age > 13 ?  "청소년" : "어린이";
		System.out.println(result);
	}
	
	//키보드로 사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method6() {
		int apple = 0;
		int basket = 0;
		int basketamount = 0;
		
		System.out.print("사과의 개수 > ");
		apple = sc.nextInt();
		System.out.print("바구니의 크기 > ");
		basket = sc.nextInt();
		
		basketamount = apple % basket == 0 ? apple / basket : (apple / basket) + 1;
		
		System.out.println("필요한 바구니의 개수 > " + basketamount);
	}
	
}