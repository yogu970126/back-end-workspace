package com.kh.practice;

import java.util.Scanner;

public class CastingPractice {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	CastingPractice cp = new CastingPractice();
	cp.method1();
	//cp.method2();


	}
	public void method1() {
		// 키보드로 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		int word = ch;
		System.out.printf("%c"word);
		System.out.printf(word+1);
		
		
		
		
	}
	
	public void method2() {
		// 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
		int kor = 0;
		int eng = 0;
		int math = 0;
		
		
		System.out.print("국어 점수 : ");
		kor = sc.nextInt();
		
		System.out.print("영어 점수 : ");
		eng = sc.nextInt();
		
		System.out.print("수학 점수 : ");
		math = sc.nextInt();
		
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("총점 : " + (kor + eng + math));
		System.out.println("평균 : " + (kor + eng + math) / 3);	
	}
}
