package com.kh.loop;

import java.util.Scanner;

public class D_While {
	Scanner sc = new Scanner(System.in);
	
	/*
	 * while문
	 * 
	 * while(조건식) {
	 * 		조건이 true일 경우 계속 실행
	 * }
	 * 
	 */
	// 1~ 5 까지 출력 : for -> while

	public void method1() {
		for(int i = 1; i<=5; i++) {
			System.out.println(i);
		}
	}
//	int i=1;
//	while(i<=5) {
//		System.out.println(i);
//		i++;
//	}
	
	/* 무한루프 @ break문
	 * 
	 * - switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * - 반복분이 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠져나ㅏㅏ
	 */

	public void method2() {
		
		while(true) {
			System.out.println("숫자 입력 > ");
			int num = sc.nextInt();
			System.out.println(num);
			if(num==0) break;
		}

	}
	
	
	
	/*
	 * do { 
	 * 		실행 코드
	 * } while(조건식);
	 * 
	 * - 조건과 상관없이 무조건 한 번은 실행
	 * */
	public void method3() {
		int number = 1;
		
		while(number == 0) {
			System.out.println("while문");
		}
		
		do {
			System.out.println("do-while문");
		} while(number == 0);
	}
	
	/*
	 * 숫자 맞히기 게임
	 * 1과 100 사이의 값을 입력해서 임의로 지정한(random)값을 맞히면 게임 끝
	 * 게임이 끝나면 몇 번만에 숫자를 맞혔는지 출력
	 * 
	 * (예 : 57)
	 * 1과 100 사이의 값 입력 > 35
	 * 더 큰 수를 입력하세요.
	 * 1과 100 사이의 값 입력 > 70
	 * 더 작은 수를 입력하세요.
	 * 1과 100 사이의 값 입력 > 57
	 * 3번 만에 맞췄습니다.
	 * */
	public void method4() {
		int random = (int)(Math.random()*100) + 1;
		int count = 1;
		
		while(true) {
			System.out.print("1과 100사이의 값 입력 > ");
			int num = sc.nextInt();
			
			if (random ==num) {
				System.out.println(count + "번 만에 맞췄습니다.");
				break;
			} else if (random > num) {
				System.out.println("더 큰 수를 입력하세요");
				count++;
			} else if (random < num) {
				System.out.println("더 작은 수를 입력하세요");
				count++;
			}
		}
	}
	public void method5() {
		/*
		 * --------------------------------
		 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
		 * --------------------------------
		 * 선택 > 1
		 * 예금액 > 5000
		 * --------------------------------
		 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
		 * --------------------------------
		 * 선택 > 2 
		 * 출금액 > 2000
		 * 
		 * */
		int select = 0;
		int acount = 0;
		
		boolean check = true;
		

		while(check) {
			System.out.println("--------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("--------------------------------");
			System.out.print("선택 > ");
			select = sc.nextInt();
			
			/*
			if(select == 1) {
				System.out.print("예금액 > ");
				acount += sc.nextInt();
			} else if(select == 2) {
				System.out.print("출금액 > ");
				acount -= sc.nextInt();
			} else if(select == 3) {
				System.out.println("잔액 > " + acount);
			} else if(select ==4) {
				System.out.println("프로그램 종료"); 	
				break;
			} */
			
			// switch문
			switch(select) {
				case 1: 
					System.out.print("예금액 > ");
					acount += sc.nextInt();
					break;
				case 2:
					System.out.print("출금액 > ");
					int ex = sc.nextInt();
					if (ex > acount) System.out.println("잔고가 부족합니다.");
					else acount -= ex;
					break;
				case 3:
					System.out.println("잔액 > " + acount);
					break;
				case 4:
					System.out.println("프로그램 종료"); 	
					check = false;
					break;
			}
			//if(select ==4) break;
		}
	}

	
	public static void main(String[] args) {
		D_While d = new D_While();
//		d.method1();
//		d.method2();
//		d.method3();
//		d.method4();
		d.method5();
	}

}
