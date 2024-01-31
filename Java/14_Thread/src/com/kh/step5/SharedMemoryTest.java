package com.kh.step5;

// 스레드들은 공유자원을 서로 공유한다
public class SharedMemoryTest {

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(cal);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(cal);
		user2.start();
		// 자원을 공유하기 때문에 user2의 50으로 둘다 출력된다
	}

}
