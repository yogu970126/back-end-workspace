package com.kh.example1.practice1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Application {

	public static void main(String[] args) {
		
		TreeSet<Integer> lotto = new TreeSet<>();

		while(lotto.size() < 6) {
			int num = (int)(Math.random() * 45 + 1);
			lotto.add(num);
		}

		int count = 0;
		
		while(true) {
			TreeSet<Integer> myLotto = new TreeSet<>();
			
			while(myLotto.size() < 6) {
				int num = (int)(Math.random() * 45 + 1);
				myLotto.add(num);
			}
			
			count++;
			System.out.println("로또 번호 : " + lotto);
			System.out.println("내 번호 : " + myLotto);
			// 로또 번호와 내 로또 번호가 일치할때 멈추게
			if(myLotto.equals(lotto)) {
				System.out.println("횟수 : " + count);
				break;
			}

		}
		
		

	}
	

	
	// 내가풀려다 망한거
	// ArrayList는 Collections.sort 를 사용해 정렬해서 비교하면 된다
	// 조건을 걸어서 중복도 안나옥 해야함 if(!(lotto.contains(num))) lotto.add(num)
//	public static void main(String[] args) {
//		int ran = (int)(Math.random() *45 +1);
//		
//		// 당첨값
//		List answerLotto = new ArrayList();
//		answerLotto.add(1);
//		answerLotto.add(8);
//		answerLotto.add(42);
//		answerLotto.add(17);
//		answerLotto.add(34);
//		answerLotto.add(25);
//		
//
//		// 6개의 랜덤 번호 생성기
//		int count = 0;
//		boolean check = true;
//
//		while(check) {
//			List lotto = new ArrayList();
//			for(int i = 0; i < 6; i++) {
//				ran = (int)(Math.random() *45 +1);
//				lotto.add(ran);
//			}
//			if(lotto.equals(answerLotto)) {
//				System.out.println("로또 번호 : "+answerLotto);
//				System.out.println("내 번호 : " + lotto);
//				System.out.println(count);
//				check = false;
//			} else if(!(lotto.equals(answerLotto))) {
//				System.out.println("로또 번호 : "+answerLotto);
//				System.out.println("내 번호 : " + lotto);
//				count++;
//			}
//		}
//	}
	
	
}







