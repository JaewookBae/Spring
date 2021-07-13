package com.ja.finalproject.board.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.finalproject.board.service.BoardServiceImpl;
import com.ja.finalproject.vo.BoardVO;
import com.ja.finalproject.vo.MemberVO;


@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService; 
	
	@RequestMapping("mainPage.do")
	public String mainPage(Model model) {
		// 할 것 참 많음...
		
		ArrayList<HashMap<String, Object>> contentlist = boardService.getContents();
		
		model.addAttribute("contentlist", contentlist);
		
		return "board/mainPage";
	}
	
	@RequestMapping("writeContentPage.do")
	public String writeContentPage() {
		
		return "board/writeContentPage";
	}
	
	@RequestMapping("writeContentProcess.do")
	public String writeContentProcess(BoardVO param, HttpSession session) {
		
		MemberVO sessionUser = (MemberVO) session.getAttribute("sessionUser");
		int member_no = sessionUser.getMember_no();
		
		param.setMember_no(member_no);
		
		boardService.writeContent(param);
		
		return "redirect:./mainPage.do";
	}
	
	@RequestMapping("readContentPage.do")
	public String readContentPage(int board_no, Model model) {
		
		//조회수 증가
		boardService.increaseReadCount(board_no);
		
		//조회
		HashMap<String, Object>  map = boardService.getContent(board_no);
		
		model.addAttribute("content", map);
		
		return "board/readContentPage";
	}
	
	@RequestMapping("delelteContentProcess.do")
	public String deleteContentProcess(int board_no) {
		
		boardService.deleteContent(board_no);
		
		return "redirect:./mainPage.do";
	}
	
	@RequestMapping("updateContentPage.do")
	public String updateContentPage(int board_no, Model model) {
		
		HashMap<String, Object>  map = boardService.getContent(board_no);
		
		model.addAttribute("content", map);
		
		return"board/updateContentPage";
	}
	
	@RequestMapping("updateContentProcess.do")
	public String updateContentProcess(BoardVO param) {
		
		boardService.updateContent(param);
		
		return "redirect:./readContentPage.do?board_no=" + param.getBoard_no();
	}
}









