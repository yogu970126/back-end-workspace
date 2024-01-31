package com.kh.step4;

import javax.swing.JOptionPane;

public class InputThreadTest3 {

	public static void main(String[] args) {
		
		InThread in = new InThread();
		in.start();
		
		for(int i = 10; i > 0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}

class InThread extends Thread {
	public void run() {
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요.."); // 입력 팝업 창 출력
		System.out.println("입력하신 숫자는 " + input + " 입니다.");
	}
}

