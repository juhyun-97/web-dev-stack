package com.kh.practice2.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class BookController {
	//Application ap = new Application();
	//Scanner sc = new Scanner(System.in);
	// (선택사항) 책 제목 기준으로 현재 대여 인원수 파악
	private Map<String, Integer> bookCount = new HashMap<>();
	
	// 책 대여
	public String rentBook(Book book, Member member) {
		member.getBookList().add(book);
		return null;
	}

}
