package com.ja.finalproject.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.finalproject.member.mapper.MemberSQLMapper;
import com.ja.finalproject.member.service.MemberServiceImpl;
import com.ja.finalproject.vo.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	//@Autowired
	//private MemberSQLMapper memberSQLMapper;
	@Autowired
	private MemberServiceImpl memberService;
	
	
	@RequestMapping("loginPage.do")
	public String loginPage() {
		
		return "member/loginPage";
	}
	
	@RequestMapping("joinMemberPage.do")
	public String joinMemberPage() {
		
		return "member/joinMemberPage";
	}
	
	@RequestMapping("joinMemberProcess.do")
	public String joinMemberProcess(MemberVO param) {
		
		//memberSQLMapper.joinMember(param);
		memberService.joinMember(param);
		
		//System.out.println("[test]" + param.getMember_id());
		//System.out.println("[test]" + param.getMember_nick());
		
		return "member/joinMemberComplete";
	}
	
	@RequestMapping("loginProcess.do")
	public String loginProcess(HttpSession session, MemberVO param) {
		
		MemberVO sessionUser = memberService.login(param);
		
		if(sessionUser != null) {
			//인증 성공
			session.setAttribute("sessionUser", sessionUser);// 중요!!!!!!!!!!!!!
			
			return "redirect:../board/mainPage.do";
		}else {
			//인증 실패
			return "member/loginFail";
		}
	}
	
	@RequestMapping("logoutProcess.do")
	public String logoutProcess(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:../board/mainPage.do";
	}
}
