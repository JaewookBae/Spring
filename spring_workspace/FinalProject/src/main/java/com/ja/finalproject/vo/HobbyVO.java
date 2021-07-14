package com.ja.finalproject.vo;

public class HobbyVO {
	
	private int hobby_no;
	private int member_no;
	private int hobby_category_no;
	
	public HobbyVO() {
	
	}

	public HobbyVO(int hobby_no, int member_no, int hobby_category_no) {
		super();
		this.hobby_no = hobby_no;
		this.member_no = member_no;
		this.hobby_category_no = hobby_category_no;
	}

	public int getHobby_no() {
		return hobby_no;
	}

	public void setHobby_no(int hobby_no) {
		this.hobby_no = hobby_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getHobby_category__no() {
		return hobby_category_no;
	}

	public void setHobby_category__no(int hobby_category_no) {
		this.hobby_category_no = hobby_category_no;
	}
	
	
}
