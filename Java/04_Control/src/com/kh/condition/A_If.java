package com.kh.condition;

import java.util.Scanner;

public class A_If {

	Scanner sc = new Scanner(System.in);

	/*
	 * if문
	 * 
	 * if (조건식) { 조건식 참(true)일 때 실행 }
	 * 
	 * - 보통 조건식에는 비교연산자, 논리연산자를 주로 사용
	 * 
	 */

	public void method1() {
		// 입력받은 성적이 60점 이상이면 "합격입니다"를 출력
		int score = 0;
		System.out.print("성적을 입력하세요 > ");
		score = sc.nextInt();
		// int score = Integer.parseInt(sc.nextLine());
		if (score >= 60) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
	}
	/*
	 * if-else문
	 * 
	 * if(조건식) { 조건식이 true일때 } else { 조건식이 false일때 }
	 */

	public void method2() {
		// 입력받은 성적이 60점 이상이면 '합격입니다', 60점 이하면 '불합격입니다' 출력
		int score = 0;
		System.out.print("성적을 입력하세요 > ");
		score = sc.nextInt();
		// int score = Integer.parseInt(sc.nextLine());
		if (score >= 60) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}

		// 삼항연산자
		// String result = score >= 60 ? "합격입니다." : "불합격입니다.";
		// System.out.println(result);
		System.out.println(score >= 60 ? "합격입니다." : "불합격입니다.");
	}

	public void method3() {
		// 본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 "본인이 아니다" 출력
		System.out.print("이름을 입력하세요 > ");
		String name = sc.next();
		// String -> 참조형 변수(클래스 변수) 는 주소값을 저장

		System.out.println("name의 주소값 : " + System.identityHashCode(name));
		System.out.println("본인이름의 주소값 : " + System.identityHashCode("이상현"));
		System.out.println(name.equals("이상현"));

		// 문자열 비교는 equals
		if (name.equals("이상현")) {
			System.out.println("본인이다");
		} else {
			System.out.println("본인이 아니다");
		}

	}

	public void method4() {
		// 입력받은 숫자가 0보다 크면 "양수", 0이면 "0이다", 작으면 "음수" 출력

		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		if (num > 0) {
			System.out.println("양수");
		} else if (num < 0) {
			System.out.println("음수");
		} else
			System.out.println("0이다.");
	}
	/*
	 * if-else if-else문
	 * 
	 * if(조건식1) { 조건식이1 참(true) 실행 } else if(조건식2) { 조건식1이 거짓이면서 조건식2가 참일 때 실행 }
	 * else {조건식1, 조건식2 모두 거짓일때 실행 }
	 * 
	 */

	/*
	 * 사용자에게 점수(0~100)를 입려받아서 점수별로 등급을 출력 90점 이샹은 A등급 90점 미만 80점 이상 B등급 80점 미만 70점
	 * 이상은 C등급 70점 미만 60점 이상흔 D등급 60점 미만 F등급
	 */
	public void practice1() {
		System.out.print("점수 입력 > ");
		int score = sc.nextInt();
		if (score >= 90) {
			System.out.println("A등급");
		} else if (score >= 80) {
			System.out.println("B등급");
		} else if (score >= 70) {
			System.out.println("C등급");
		} else if (score >= 60) {
			System.out.println("D등급");
		} else {
			System.out.println("F등급");
		}
		
		String grade = "";
		if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 60) {
			grade = "D";
		} else {
			grade = "E";
		}
		System.out.println(grade + "등급");

	}

	/*
	 * 세 정수를 입력했을 때 짝수만 출력
	 * 
	 * num1 입력 > 3 num2 입력 > 4 num3 입력 > 6
	 * 
	 * 4 6
	 */
	public void practice2() {
		System.out.print("num1 입력 > ");
		int num1 = sc.nextInt();
		System.out.print("num2 입력 > ");
		int num2 = sc.nextInt();
		System.out.print("num3 입력 > ");
		int num3 = sc.nextInt();

		if (num1 % 2 == 0) {
			System.out.println(num1);
		}
		if (num2 % 2 == 0) {
			System.out.println(num2);
		}
		if (num3 % 2 == 0) {
			System.out.println(num3);
		}
	}

	/*
	 * 정수 1개를 입력했을 때 음(minus) / 양(plus) / 0(zero) , 짝(even) / 홀(odd) 출력
	 * 
	 * 정수 입력 -> 3 minus odd
	 */
	public void practice3() {
		System.out.print("정수 입력 -> ");
		int num = sc.nextInt();

		if (num < 0) {
			System.out.println("minus");
			if (num % 2 == 0) {
				System.out.println("even");
			} else {
				System.out.println("odd");
			}
		} else if (num > 0) {
			System.out.println("plus");
			if (num % 2 == 0) {
				System.out.println("even");
			} else {
				System.out.println("odd");
			}
		} else
			System.out.println("zero");
	}

	public static void main(String[] args) {
		A_If a = new A_If();
		// a.method1();
		// a.method2();
		// a.method3();
		// a.method4();
		// a.practice1();
		// a.practice2();
		 a.practice3();
	}

}
