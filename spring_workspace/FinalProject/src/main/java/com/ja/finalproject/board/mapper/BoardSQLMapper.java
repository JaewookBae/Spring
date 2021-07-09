package com.ja.finalproject.board.mapper;

import java.util.ArrayList;

import com.ja.finalproject.vo.BoardVO;

public interface BoardSQLMapper {

	//insert querry
	public void writeContent(BoardVO vo);
	
	//select
	public ArrayList<BoardVO> getContents();
}
