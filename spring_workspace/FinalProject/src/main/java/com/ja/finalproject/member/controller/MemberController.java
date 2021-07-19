package com.ja.finalproject.member.controller;

import java.util.ArrayList;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.finalproject.member.mapper.MemberSQLMapper;
import com.ja.finalproject.member.service.MemberServiceImpl;
import com.ja.finalproject.vo.HobbyCategoryVO;
import com.ja.finalproject.vo.MailAuthVO;
import com.ja.finalproject.vo.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	
	//@Autowired
	//private MemberSQLMapper memberSQLMapper;
	@Autowired
	private MemberServiceImpl memberService;
	
	
	@RequestMapping("loginPage.do")
	public String loginPage() {
		
		return "member/loginPage";
	}
	
	@RequestMapping("joinMemberPage.do")
	public String joinMemberPage(Model model) {
		
		ArrayList<HobbyCategoryVO> list =  memberService.getHobbyCategoryList();
		
		model.addAttribute("hobbyCategoryList", list);
		
		return "member/joinMemberPage";
	}
	
	@RequestMapping("joinMemberProcess.do")
	public String joinMemberProcess(MemberVO param, int [] hobby_category_no) {
				
		String uuid = UUID.randomUUID().toString();	
		
		MailAuthVO mailAuthVO = new MailAuthVO();
		mailAuthVO.setMailauth_key(uuid);
		
		//메일 보내는 쓰레드 생성 및 실행
		
		MailSendThread th = new MailSendThread(mailSender, param.getMember_email(), uuid);
		th.start();
		
		memberService.joinMember(param, hobby_category_no, mailAuthVO);
		
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
	
	@RequestMapping("certifyMail.do")
	public String certifyMail(String mailauth_key) {
		
		memberService.certifyMail(mailauth_key);
		
		return "member/certifyMailComplete";
	}
}

class MailSendThread extends Thread{
	
	private JavaMailSender mailSender;
	private String mailAddress;
	private String key;
	
	public MailSendThread(JavaMailSender mailSender, String mailAddress, String key) {
		this.mailSender = mailSender;
		this.mailAddress = mailAddress;
		this.key = key;
	}
	
	public void run() {
		try {			
		
			MimeMessage mimeMessage =  mailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			
			mimeMessageHelper.setSubject("[인증 메일] 회원 가입을 축하드립니다.");
			
			String text = "";
			text += "<h1>회원 가입 완료</h1>";
			text += "다음 링크를 클릭하여 인증을 완료해 주세요.<br>";
			text += "<a href='http://localhost:8181/finalproject/member/certifyMail.do?mailauth_key="+key+"'>";
			text += "인증하기";
			text += "</a>";
			
			mimeMessageHelper.setText(text,true);
			mimeMessageHelper.setFrom("admin", "사이트 관리자");
			
			mimeMessageHelper.setTo(mailAddress);
			
			mailSender.send(mimeMessage);
			
			} catch(Exception e) {
				e.printStackTrace();
		}
	}
}






