package com.hud.model;

public class MailVo {
	private String to; 	//받는 사람
	private String title;//제목
	private String content;//내용
	private String from;//보낸느 사람
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	@Override
	public String toString() {
		return "MailVo [to=" + to + ", title=" + title + ", content=" + content + ", from=" + from + "]";
	}
	
	
	
	
	
}
