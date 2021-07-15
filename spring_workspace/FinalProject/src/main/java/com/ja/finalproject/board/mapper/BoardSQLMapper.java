package com.ja.finalproject.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ja.finalproject.vo.BoardVO;

public interface BoardSQLMapper {

	// insert querry
	public void writeContent(BoardVO vo);

	// select
	public ArrayList<BoardVO> getContents(
			@Param("search_type") String search_type, 
			@Param("search_word") String search_word,
			@Param("page_num") int page_num
			); 
	
	public int getContentCount(
			@Param("search_type") String search_type, 
			@Param("search_word") String search_word,
			@Param("page_num") int page_num			
			);

	public BoardVO getContentByNO(int board_no);

	// delete
	public void deleteContent(int board_no);

	// update
	public void updateContent(BoardVO vo);

	// 조회수 증가
	public void increaseReadCount(int board_no);
}
