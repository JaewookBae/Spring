package com.ja.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/test1.do")
	public void test1() {
		System.out.println("Hello");
	}
	
	@RequestMapping("/test2.do")
	public void test2() {
		System.out.println("Hello22222");		
	}
}
