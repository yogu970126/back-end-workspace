package com.kh.step3;

// '띵~' 메세지 출력 스레드
public class Beep2Thread implements Runnable {
	
	public void run() {
		
		for(int i = 0; i < 5; i++) {
			System.out.println("띵~~");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
