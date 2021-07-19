package com.ja.finalproject.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.commons.MessageDigestUtil;
import com.ja.finalproject.member.mapper.MemberSQLMapper;
import com.ja.finalproject.vo.HobbyCategoryVO;
import com.ja.finalproject.vo.HobbyVO;
import com.ja.finalproject.vo.MailAuthVO;
import com.ja.finalproject.vo.MemberVO;

@Service
public class MemberServiceImpl {
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void joinMember(MemberVO vo, int [] hobby_category_no, MailAuthVO mailAuthVO) {
		
		int member_no = memberSQLMapper.createMemberPK();
		vo.setMember_no(member_no);
		
		//비밀번호 해쉬값 획득 및 변경
		System.out.println("[test]비밀번호 변경 전 : " + vo.getMember_pw());
		String hashCode = MessageDigestUtil .getPasswordHashCode(vo.getMember_pw());
		vo.setMember_pw(hashCode);
		System.out.println("[test]비밀번호 변경 후 : " + vo.getMember_pw());
		
		memberSQLMapper.joinMember(vo);
		
		mailAuthVO.setMember_no(member_no);
		memberSQLMapper.createMailAuthInfo(mailAuthVO);

		if(hobby_category_no == null) {
			return;
		}
		
		for(int hobby : hobby_category_no) {
			HobbyVO hobbyVO = new HobbyVO();
			hobbyVO.setHobby_category__no(hobby);
			hobbyVO.setMember_no(member_no);
			
			memberSQLMapper.registerHobby(hobbyVO);
		}
		
		
	}
	
	public MemberVO login(MemberVO param) {
		
		String hashCode = MessageDigestUtil.getPasswordHashCode(param.getMember_pw());
		param.setMember_pw(hashCode);
		
		
		MemberVO result = memberSQLMapper.getMemberByIdAndPw(param);
		
		return result;
	}
	
	//hobby category
	public ArrayList<HobbyCategoryVO> getHobbyCategoryList(){
		
		return memberSQLMapper.getCategoryList();
	}
	
	public void certifyMail(String key) {
		
		memberSQLMapper.certifyMail(key);
	}
}



