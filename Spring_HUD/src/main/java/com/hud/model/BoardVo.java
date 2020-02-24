package com.hud.model;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class BoardVo {
	private int no;//no
	private String subject;//subject
	private String content;//content
	private String writer;//writer
	private String write_date;//write_date
	private int cnt;//cnt
	
	
	private String img;
	private String thumbImg;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getThumbImg() {
		return thumbImg;
	}
	public void setThumbImg(String thumbImg) {
		this.thumbImg = thumbImg;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", subject=" + subject + ", content=" + content + ", writer=" + writer
				+ ", write_date=" + write_date + ", cnt=" + cnt + ", img=" + img + ", thumbImg=" + thumbImg + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
