package com.ja.finalproject.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.member.mapper.MemberSQLMapper;
import com.ja.finalproject.vo.MemberVO;

@Service
public class MemberServiceImpl {
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void joinMember(MemberVO vo) {
		
		memberSQLMapper.joinMember(vo);
		
	}
	
	public MemberVO login(MemberVO param) {
			
		MemberVO result = memberSQLMapper.getMemberByIdAndPw(param);
		
		return result;
	}
}
