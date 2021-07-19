package com.ja.finalproject.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.ja.finalproject.vo.MemberVO;

public class AuthIntercepter extends WebContentInterceptor{
	//오버라이딩
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) throws ModelAndViewDefiningException {
		
		MemberVO sessionUser = (MemberVO) request.getSession().getAttribute("sessionUser");
		
		if(sessionUser == null) {
			ModelAndView mv = new ModelAndView("member/LoginRequired");
			throw new ModelAndViewDefiningException(mv);
		}
		//System.out.println("[인터셉터 테스트]");
		
		return true;
	}
	
}
