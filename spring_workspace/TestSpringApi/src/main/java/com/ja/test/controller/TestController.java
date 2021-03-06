package com.ja.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/test1.do")
	public String test1() {
		
		System.out.println("안녕하세요");
		
		return "test1";
	}
	
	@RequestMapping("/test2.do")
	public String test2(HttpServletRequest request) {
				
		String v1 = request.getParameter("v1");
		System.out.println(v1);
		
		return "test2";
	}
	
	@RequestMapping("/test3.do")
	public String test3(int v1, int v2, Model model) {
		
		System.out.println(v1);
		System.out.println(v2);
		
		int result = v1 + v2;
		System.out.println(result);
		
		model.addAttribute("rrr", result);// request 저장공간에 addAttribute을 한다. 
		
		return "test";
	}
}
