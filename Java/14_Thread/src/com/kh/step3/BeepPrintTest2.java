package com.kh.step3;

public class BeepPrintTest2 {

	public static void main(String[] args) {
		
		// 메인도 하나의 스레드라 한개는 두고 하나만 스레드로 만들면 된다
		// 강사님 깃헙 파일 참고
		BeepThread beep = new BeepThread();
		Beep2Thread beep2 = new Beep2Thread();
		
		Thread tbeep = new Thread(beep);
		Thread tbeep2 = new Thread(beep2);
	
		tbeep.start();
		tbeep2.start();
		
	}

}
