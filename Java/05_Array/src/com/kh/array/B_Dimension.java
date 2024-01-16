package com.kh.array;

import java.util.Arrays;

public class B_Dimension {
	
	/*
	 * 다차원 배열 : '[]'의 개수가 차원의 수를 의미
	 * 
	 * 1. 2차원 배열의 선언 
	 * 
	 * 	자료형[][] 배열명;
	 * 	자료형 배열명[][];
	 * 	자료형[] 배열명[];
	 * 
	 * 2. 2차원 배열의 생성
	 * 
	 * 	배열명 = new 자료형[행크기][열크기];
	 * 
	 * 3. 2차원 배열의 선언과 초기화를 동시 진행
	 * 
	 * 	자료형[][] 배열명 = new 자료형[행크기][열크기];
	 * 
	 * 	배열명 [0][0] = 값;
	 * 	배열명 [0][1] = 값;
	 * 	...
	 * */
	public void method1() {
		int[][] arr = {{1, 2, 3, 4, 5},{6, 7, 8, 9, 10},{11, 12, 13, 14, 15}};
		/*
		 * [1, 2, 3, 4, 5]
		 * [6, 7, 8, 9, 10]
		 * [11, 12, 13, 14, 15]
		 * 
		 * */
		for(int i =0; i <arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		/*
		 * 1
		 * 2
		 * 3
		 * ...
		 * 14
		 * 15
		 * */
/*		for(int i =0; i <arr.length; i++) {
			for (int j =0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]); 
			}
		} 
		*/
		// 향상된 for문
		for(int[] i :arr) {
			System.out.println(Arrays.toString(i));
			for(int j : i) {
				System.out.println(j);
			}
		}
		
	}
	// 가변 배열 : 다차원 뱅ㄹ에서 마지막 차수의 크기를 지정하지 않고 다르게 지정
	/*
	 * [HTML, CSS, JavaScript]
	 * [MySQL, Java, JDBC, JSP]
	 * [JQuery, MyBatis, Spring]
	 * [Spring Boot, react]
	 * */
	public void method2() {
		String[][] arr = {{"HTML", "CSS", "JavaScript"},{"MySQL", "Java", "JDBC", "JSP"},
						   {"JQuery", "MyBatis", "Spring"}, {"Spring Boot", "react"}};
		
		for (int i =0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}

	public static void main(String[] args) {
		B_Dimension b = new B_Dimension();
//		b.method1();
		b.method2();

	}

}
