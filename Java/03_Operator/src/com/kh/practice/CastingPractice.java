package com.kh.practice;

import java.util.Scanner;

public class CastingPractice {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	CastingPractice cp = new CastingPractice();
//	cp.method1();
	cp.method2();


	}
	public void method1() {
		// 키보드로 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		int word = ch;
		System.out.println(ch + " unicode : " + word);
		System.out.println((char)(ch+1) + " unicode : " + (word+1));		
	}
	
	public void method2() {
		// 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
		
		System.out.print("국어 점수 : ");
		double kor = sc.nextInt();
		
		System.out.print("영어 점수 : ");
		double eng = sc.nextInt();
		
		System.out.print("수학 점수 : ");
		double math = sc.nextInt();
		
		double avg = (kor + eng + math) / 3;
		
		System.out.println("국어 : "+ (int)kor);
		System.out.println("영어 : "+ (int)eng);
		System.out.println("수학 : "+ (int)math);
		System.out.println("총점 : "+ (int)(kor + eng + math));
		System.out.printf("평균 : %.2f", avg);	
	}
}
