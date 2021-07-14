package com.ja.finalproject.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.member.mapper.MemberSQLMapper;
import com.ja.finalproject.vo.HobbyCategoryVO;
import com.ja.finalproject.vo.HobbyVO;
import com.ja.finalproject.vo.MemberVO;

@Service
public class MemberServiceImpl {
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void joinMember(MemberVO vo, int [] hobby_category_no) {
		
		int member_no = memberSQLMapper.createMemberPK();
		vo.setMember_no(member_no);
		
		memberSQLMapper.joinMember(vo);
		
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
			
		MemberVO result = memberSQLMapper.getMemberByIdAndPw(param);
		
		return result;
	}
	
	//hobby category
	public ArrayList<HobbyCategoryVO> getHobbyCategoryList(){
		
		return memberSQLMapper.getCategoryList();
	}
}
