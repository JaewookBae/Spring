package com.ja.finalproject.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.board.mapper.BoardSQLMapper;
import com.ja.finalproject.member.mapper.MemberSQLMapper;
import com.ja.finalproject.vo.BoardVO;
import com.ja.finalproject.vo.MemberVO;

@Service
public class BoardServiceImpl {
	
	@Autowired
	private BoardSQLMapper boardSQLMapper;
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void writeContent(BoardVO vo) {
		
		boardSQLMapper.writeContent(vo);
		
	}
	
	public ArrayList<HashMap<String, Object>> getContents() {
		
		// 자료 구조의 활용..메모리 관리의 중요한 내용..체크 해두기!!!
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		ArrayList<BoardVO> boardlist = boardSQLMapper.getContents();
		
		for(BoardVO boardVO : boardlist) {
			
			int memberNo = boardVO.getMember_no();
			MemberVO memberVO =  memberSQLMapper.getMemberByNo(memberNo);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("memberVO", memberVO);
			map.put("boardVO", boardVO);
			
			list.add(map);
		}
		return list;
	}
	
	public HashMap<String, Object> getContent(int board_no) {
		
		BoardVO boardVO = boardSQLMapper.getContentByNO(board_no);
		
		//html escape
		String content = boardVO.getBoard_content();
		System.out.println("[변환 전 테스트]" + content);
		
		content = StringEscapeUtils.escapeHtml4(content); 
		System.out.println("[변환 후 테스트]" + content);		
		content = content.replaceAll("\n", "<br>");
		
		boardVO.setBoard_content(content);
		
		
		int member_no = boardVO.getMember_no();
		MemberVO memberVO = memberSQLMapper.getMemberByNo(member_no);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("memberVO", memberVO);
		map.put("boardVO", boardVO);
	
		return map;
	}
	
	public void increaseReadCount(int board_no) {
		boardSQLMapper.increaseReadCount(board_no);
	}
	
	public void deleteContent(int board_no) {
		boardSQLMapper.deleteContent(board_no);
	}
	
	public void updateContent(BoardVO vo) {
		boardSQLMapper.updateContent(vo);
	}
}
