package com.kh._abstract.step1;

public class Football extends Sports{
	protected int numberOfPlayers; // 참여하는 사람의 수
	
	public Football(int numberOfPlayers) {
		super(numberOfPlayers);
	}
	
	public void rule() {
		System.out.println("Football의 선수의 수는 " + this.numberOfPlayers 
						+ "명, 손이 아닌 발로 공을 차야한다.");
	}

}
