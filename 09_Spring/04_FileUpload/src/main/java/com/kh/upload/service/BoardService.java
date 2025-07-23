package com.kh.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.mapper.BoardMapper;
import com.kh.upload.vo.Board;

@Service
public class BoardService {
 
	@Autowired
	private BoardMapper mapper;

	public String insertBoard() {
		return mapper.insertBoard();
	}
	
	public List<Board> showAll() {
		return mapper.showAll();
	}
	
	public void deleteBoard(String no) {
		mapper.deleteBoard(no);
	}
}
