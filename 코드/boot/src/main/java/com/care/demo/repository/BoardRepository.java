package com.care.demo.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.care.demo.dto.BoardDTO;

@Mapper
public interface BoardRepository {

	void write(BoardDTO board);

//	List<BoardDTO> board();
	List<BoardDTO> board(
			@Param("b")int begin,
			@Param("e") int end, 
			@Param("sel") String select,
			@Param("search") String search);
	
	int boardCount(Map<String, Object> map);

	BoardDTO view(int bNumber);

	void vCountInc(int bNumber);

	void removeProc(int bNumber);

	BoardDTO modify(int bNumber);

	int modifyProc(BoardDTO board);
}
