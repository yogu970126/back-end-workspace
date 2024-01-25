package com.kh.list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class B_Other {

	/*
	 * 여기 나오는 것들은 딱히 쓰지는 않고 볼일도 거의 없다.
	 * 하지만 정보처리기사 시험볼땐 나온다
	 * */
	public static void main(String[] args) {
		B_Other b = new B_Other();
//		b.method1();
//		b.method2();
		b.method3();
	}
	
	
	/*
	 * Vector 
	 * - 동기화된(synchronized) 메서드로 구성 (개념을 스레드를 알아야함! 뒤에서~)
	 * */
	public void method1() {
		Vector v = new Vector();
		v.add(0);
		v.add(1);
		System.out.println(v);
		System.out.println("size : " + v.size());
		System.out.println("capacity : " + v.capacity());
		
		v.trimToSize();
		System.out.println("size : " + v.size());
		System.out.println("capacity : " + v.capacity());
	}
	
	// 스택 (Stack) : 마지막에 저장한 것을 제일 먼저 꺼내는 LIFO(Last In First Out) 구조
	public void method2() {
		
		Stack s = new Stack();
		
		s.push(0);
		s.push(1);
		s.push(2);
		s.push(3);
		s.pop(); // 마지막에 저장한 3 없어짐
		
		s.push(4);
		s.pop();
		s.push(5);
		s.push(6);
		s.push(7);
		s.pop();
		
		System.out.println(s); // 0 1 2 5 6
		
	}
	
	// 큐 (Queue) : 처음에 저장한 것을 제일 먼저 꺼내는 FIFO(First In First Out) 구조
	public void method3() {
		
		// 큐는 클래스가 아니라 인터페이스

		Queue q = new LinkedList();
		
		q.offer(0); // 값 넣을때 
		q.offer(1);
		q.offer(2);
		q.offer(3);
		
		q.poll(); // 값 뺄때 
		q.add(4);
		q.remove();
		q.add(5);
		q.add(6);
		q.add(7);
		q.remove();
		
		System.out.println(q); // 3 4 5 6 7
		
	}
	

}







































