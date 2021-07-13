package com.ja.finalproject.board.mapper;

import java.util.ArrayList;

import com.ja.finalproject.vo.BoardVO;

public interface BoardSQLMapper {

	//insert querry
	public void writeContent(BoardVO vo);
	
	//select
	public ArrayList<BoardVO> getContents();
<<<<<<< HEAD

	public BoardVO getContentByNO(int board_no);
	
	//delete
	public void deleteContent(int board_no);
	
	//update
	public void updateContent(BoardVO vo);
	
	//조회수 증가
	public void increaseReadCount(int board_no);
	
=======
>>>>>>> 9d0de95df9bce7cac0f6d41a5bb747213a9e0a1a
}
