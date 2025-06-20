package com.kh.practice2.controller;

import com.kh.practice2.model.Snack;

public class SnackController {

	
	private Snack s = new Snack();
	
	
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		// 저장 로직 구현!
		// setter
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		
		return "저장 완료되었습니다.";
		
	}

	public String confirmData() {
		// getter 

		return "빵(" + s.getName() + " - " +  s.getFlavor() + ") " + s.getNumOf() + "개 " + s.getPrice() + "원"; 
		
	}




}
