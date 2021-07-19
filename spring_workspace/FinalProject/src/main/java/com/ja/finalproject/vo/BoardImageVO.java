package com.ja.finalproject.vo;

public class BoardImageVO {

	private int image_no;
	private int board_no;
	private String image_url;
	private String image_ori;
	
	public BoardImageVO() {
	
	}

	public BoardImageVO(int image_no, int board_no, String image_url, String image_ori) {
		super();
		this.image_no = image_no;
		this.board_no = board_no;
		this.image_url = image_url;
		this.image_ori = image_ori;
	}

	public int getImage_no() {
		return image_no;
	}

	public void setImage_no(int image_no) {
		this.image_no = image_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getImage_ori() {
		return image_ori;
	}

	public void setImage_ori(String image_ori) {
		this.image_ori = image_ori;
	}
}

