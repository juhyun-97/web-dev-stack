package com.kh.practice3.controller;

import java.util.ArrayList;

import com.kh.practice3.model.Music;


public class MusicController {

	private ArrayList<Music> list = new ArrayList<>();
	
	//1. 특정 곡 추가  add
	public boolean addList(String artist, String song) {
		
		// 추가실패
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getArtist().equals(artist) && list.get(i).getSong().equals(song)) {
				System.out.println("추가 실패");
				return false;
			}
		}
		
		list.add(new Music(artist, song));
		return true;
		
	}
	
	//2. 전체 곡 목록 출력
	public ArrayList<Music> printAll() {
		return list;
	}
	// 검색할 곡이 있다면 "(가수 - 곡)을 검색했습니다." 없다면 "검색할 곡을 찾지 못했습니다."
	//3. 특정 곡 검색 contains
	public void searchMusic(String artist, String song) {
		for(int i = 0; i < list.size(); i++) {
			if(list.contains(song)) {
				System.out.println(artist + " - " + song + "을 검색했습니다.");
			} else {
				System.out.println("검색할 곡을 찾지 못했습니다.");
			}
		}
		
		
		/*
		 * ****** 특정 곡 검색(가수/곡) ******
		 * 키워드 검색 :
		 * 
		 * 검색할 곡이 있다면 "(가수 - 곡)을 검색했습니다."
		 * 			없다면 "검색할 곡을 찾지 못했습니다."
		 * */
		
	}
	
	//4. 특정 곡 수정 set
	public void updateMusic() {
		list.set(0, null);
	}
	
	//5. 특정 곡 삭제 remove
	public void removeMusic() {
		list.remove(0);
	}
	
}