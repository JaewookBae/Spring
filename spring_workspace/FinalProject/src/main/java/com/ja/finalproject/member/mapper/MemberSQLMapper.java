package com.ja.finalproject.member.mapper;

import com.ja.finalproject.vo.MemberVO;

public interface MemberSQLMapper {
	
	public void joinMember(MemberVO vo);
	
	public MemberVO getMemberByIdAndPw(MemberVO vo);
	
	public MemberVO getMemberByNo(int no);
}
