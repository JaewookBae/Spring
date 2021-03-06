package com.ja.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	//리다이렉트
	@RequestMapping("test7.do")
	public String test7() {
		
		return "redirect:./aaaa";
	}
	
	
	
	//@RequestMapping("test6.do")
	//@GetMapping("test6.do")
	@PostMapping("test6.do")
	public String test6() {
		
		return "aaaa";
	}
	
	// 파라미터 받는 방법 : 
	@RequestMapping("/{groupName}/{nickName}/memberPage.do")
	public String memberPage(
			@PathVariable("nickName") String nickName,
			@PathVariable("groupName") String groupName
			) {
		
		System.out.println( nickName);
		System.out.println(groupName);
		
		return "aaaa";
	}
	
	@RequestMapping("test5.do")
	public String test5(String a, String b, String c) {
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		return "aaaa";
	}
	
	@RequestMapping("test4.do")
	public String test4(@RequestParam(value= "str" , defaultValue = "0") int str) {
		
		System.out.println(str);
		
		return "test4";
	}
	
	//리턴 타입 사용 기준..String
	@RequestMapping("test1.do")
	public String test1() {
		
		return "abcd";
	}
	
	@RequestMapping("test2.do")
	public ModelAndView test2() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("aavv");
		
		return mav;
	}
	
	@RequestMapping("loginPage.do")
	public void loginPage() {
		System.out.println("로그인 관련 로직...");
	}
	
	@RequestMapping("joinMemberPage.do")
	public String joinMemberPage() {
		
		return "joinMemberPage";
	}
}
