package com.ja.finalproject.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@RequestMapping("/mainPage.do")
	public String mainPage() {
			
		return "board/mainPage";
	}
}
