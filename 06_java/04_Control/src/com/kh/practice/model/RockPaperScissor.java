package com.kh.practice.model;

import java.util.Arrays;

// 캡슐화! -> Single Responsibility Principle (SRP 원칙)
public class RockPaperScissor { // private = 해당 클래스에서만 사용가능함. 다른곳에선 사용 불가
	private String[] rps = {"가위" , "바위", "보"};
	private int win = 0;
	private int lose = 0;
	private int draw = 0;
	
	// alt + shift + s
	// superclass 에서 추가, using Fields에서 추가, getters and setters select all 클릭후 추가, tostring 추가
	
	public RockPaperScissor() {
		
	}

	public RockPaperScissor(String[] rps, int win, int lose, int draw) {
		this.rps = rps;
		this.win = win;
		this.lose = lose;
		this.draw = draw;
	}

	public String[] getRps() {
		return rps;
	}

	public void setRps(String[] rps) {
		this.rps = rps;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	@Override
	public String toString() {
		return "RockPaperScissor [rps=" + Arrays.toString(rps) + ", win=" + win + ", lose=" + lose + ", draw=" + draw
				+ "]";
	}
	
	
	
	
}
