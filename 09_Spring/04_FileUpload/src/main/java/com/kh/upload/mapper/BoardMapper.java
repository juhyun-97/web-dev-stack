package com.kh.upload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.vo.Board;

@Mapper
public interface BoardMapper {

	String insertBoard();
	List<Board> showAll();
	void deleteBoard(String no);
}
