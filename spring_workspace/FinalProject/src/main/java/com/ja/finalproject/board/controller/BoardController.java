package com.ja.finalproject.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ja.finalproject.board.service.BoardServiceImpl;
import com.ja.finalproject.vo.BoardImageVO;
import com.ja.finalproject.vo.BoardVO;
import com.ja.finalproject.vo.MemberVO;


@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService; 
	
	@RequestMapping("mainPage.do")
	public String mainPage(
			Model model, 
			String search_word, 
			String search_type, 
			@RequestParam(defaultValue = "1") int page_num) {
		// 할 것 참 많음...
		
		ArrayList<HashMap<String, Object>> contentlist = boardService.getContents(search_type, search_word,page_num);
		
		int count = boardService.getContentCount(search_type, search_word, page_num);
		
		int totalPageCount = (int)Math.ceil(count/10.0);
		int currentPage = page_num;
		
		int beginPage = ((currentPage-1)/5) * 5 + 1;
		int endPage = ((currentPage-1)/5 + 1) * (5);
		
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		String addParam = "";

		if(search_type != null && search_word != null) {
			addParam += "&search_type=" + search_type;
			addParam += "&search_word=" + search_word;
		}
		
		model.addAttribute("addParam", addParam);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("beginPage", beginPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPageCount", totalPageCount);
		
		model.addAttribute("contentlist", contentlist);
		
		return "board/mainPage";
	}
	
	@RequestMapping("writeContentPage.do")
	public String writeContentPage() {
		
		return "board/writeContentPage";
	}
	
	@RequestMapping("writeContentProcess.do")
	public String writeContentProcess(BoardVO param, MultipartFile [] board_files, HttpSession session) {
		
		ArrayList<BoardImageVO> boardImageVOList = 
				new ArrayList<BoardImageVO>();
		
			//파일 업로드
			for(MultipartFile boardFile : board_files) {
			//예외처리 : 하나도 안날려도 왠지 모르게 한바퀴는 돈다.
			if(boardFile.isEmpty()) {
				continue;
			}
			
			String rootFolderName = "C:/uploadFolder/";
			
			//랜덤 파일 네임 만들기 : 충돌 방지(시간 + 랜덤 활용)
			String originalFilename = boardFile.getOriginalFilename();
			String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
			String uuidName = UUID.randomUUID().toString();
			long currentTimeMillis = System.currentTimeMillis();
			String randomFileName = uuidName + "_" + currentTimeMillis + ext;
			
			//오늘 날짜 폴더 만들기
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String todayFolderName = sdf.format(today);
			String uploadFolderName = rootFolderName + todayFolderName;

			File uploadFolder = new File(uploadFolderName);
			
			if(!uploadFolder.exists()) {
				uploadFolder.mkdirs();
			}
			
			String saveFilePathName = uploadFolderName + "/" + randomFileName;
			
			try {	
				boardFile.transferTo(new File(saveFilePathName));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//데이터 처리
			BoardImageVO boardImageVO = new BoardImageVO();
			boardImageVO.setImage_ori(originalFilename);
			boardImageVO.setImage_url(todayFolderName + "/" + randomFileName);
			
			boardImageVOList.add(boardImageVO);
			
		}
		
		//아래 데이터 처리
		
		// 공부 해야될 곳
		MemberVO sessionUser = (MemberVO) session.getAttribute("sessionUser");
		int member_no = sessionUser.getMember_no();
		
		param.setMember_no(member_no);
		
		boardService.writeContent(param, boardImageVOList);
		
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









