package com.kh.step4;

import javax.swing.JOptionPane;

// 두 쓰레드간의 Communication은 프로세스의 자원으로 해야한다.
// 프로세스
public class InputThreadTest3_2 {
	
	boolean check = false;

	public static void main(String[] args) {	
		
		InputThreadTest3_2 process = new InputThreadTest3_2();
		
		// 1. 로또번호 입력
		InThread3 in = new InThread3(process);
		in.start();
		
		// 2. 카운팅 작업
		CountThread3 count = new CountThread3(process);
		count.start();

	}
}

class InThread3 extends Thread {
	
	InputThreadTest3_2 process;
	
	InThread3(InputThreadTest3_2 process) {
		this.process = process;
	}
	
	public void run() {
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요.."); // 입력 팝업 창 출력
		System.out.println("입력하신 숫자는 " + input + " 입니다.");
		
		process.check = true;
		
	}
}


class CountThread3 extends Thread {	
	
	InputThreadTest3_2 process;
	
	CountThread3(InputThreadTest3_2 process) {
		this.process = process;
	}
	
	public void run() {
		for(int i = 10; i > 0; i--) {
			if(process.check) break;
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(!process.check) {
			System.out.println("10초 경과! 값 입력 중지");
			System.exit(0); // 강제 종료
		}
	}
}

