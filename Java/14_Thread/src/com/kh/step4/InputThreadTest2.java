package com.kh.step4;

import javax.swing.JOptionPane;

public class InputThreadTest2 {

	public static void main(String[] args) {
		
		CountThread count = new CountThread();
		count.start();
		
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요.."); // 입력 팝업 창 출력
		System.out.println("입력하신 숫자는 " + input + " 입니다.");
			
		
	}

}

class InputThread extends Thread {
	
	
}