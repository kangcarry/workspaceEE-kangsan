package com.itwill.shop.board;

import java.sql.Date;

public class Board {
	private int board_no;
	private String board_title;
	private String user_id;
	private String board_content;
	private Date board_regDate;
	private int board_readCount;
	//글의 논리적인 순서번호를 관리하기 위한 필드 (3개)
	private int board_group_no;
	private int board_step;
	private int board_depth;
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_regDate() {
		return board_regDate;
	}
	public void setBoard_regDate(Date board_regDate) {
		this.board_regDate = board_regDate;
	}
	public int getBoard_readCount() {
		return board_readCount;
	}
	public void setBoard_readCount(int board_readCount) {
		this.board_readCount = board_readCount;
	}
	public int getBoard_group_no() {
		return board_group_no;
	}
	public void setBoard_group_no(int board_group_no) {
		this.board_group_no = board_group_no;
	}
	public int getBoard_step() {
		return board_step;
	}
	public void setBoard_step(int board_step) {
		this.board_step = board_step;
	}
	public int getBoard_depth() {
		return board_depth;
	}
	public void setBoard_depth(int board_depth) {
		this.board_depth = board_depth;
	}
	
	
}
