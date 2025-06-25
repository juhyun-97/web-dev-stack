package com.kh._abstract.step1;

public class FootBall extends Sports {

	public FootBall(int numOfPlayers) {
		super(numOfPlayers);
	}

	@Override
	public void rule() {
		System.out.println("Football의 선수 수는 "
				+ this.numOfPlayers + "명, 손이 아닌 발로 공을 차야 한다");
	}

}