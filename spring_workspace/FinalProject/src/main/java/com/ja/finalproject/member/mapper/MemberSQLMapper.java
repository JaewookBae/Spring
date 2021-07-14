package com.ja.finalproject.member.mapper;

import java.util.ArrayList;

import com.ja.finalproject.vo.HobbyCategoryVO;
import com.ja.finalproject.vo.HobbyVO;
import com.ja.finalproject.vo.MemberVO;

public interface MemberSQLMapper {
	
	public int createMemberPK();
	
	public void joinMember(MemberVO vo);
	
	public MemberVO getMemberByIdAndPw(MemberVO vo);
	
	public MemberVO getMemberByNo(int no);
	
	//hobby Table관련
	public ArrayList<HobbyCategoryVO> getCategoryList();
	
	public void registerHobby(HobbyVO vo);
}
