package com.kh.mybatis.model.dto;

import lombok.Getter;
import lombok.Setter;

// DTO(Data Transfer Object) : 데이터 전송 객체(데이터 전송량이 많을때)
@Getter @Setter
public class SearchDTO {

	private String select;
	private String keyword;
}
