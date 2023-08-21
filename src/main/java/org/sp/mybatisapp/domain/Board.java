package org.sp.mybatisapp.domain;

public class Board {
	private int board_idx;
	private String title;
	private String writer;
	private String regdate;
	private int hit;
	private String content;
	
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
