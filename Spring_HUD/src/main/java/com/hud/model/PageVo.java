package com.hud.model;

public class PageVo {
	//페이징의 시작번호
	private int startPage;
	//페이징의 끝번호
	private int endPage;
	//페이지의 이전
	private boolean prev;
	//페이지의 다음
	private boolean next;
	private int displayPageNum=10;
	private int total;
	private Criteria cri;
	
	
	public PageVo(Criteria cri,int total) {//매개변수 2개인 생성자
		this.cri=cri;
		this.total=total;
		//페이징의 끝번호를 알수있게 계산
		this.endPage=(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage=this.endPage-9;
		int realEnd=(int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if(realEnd<this.endPage) {
			this.endPage=realEnd;
		}
		this.prev=this.startPage>1;
		
		this.next=this.endPage <realEnd;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public int getDisplayPageNum() {
		return displayPageNum;
	}


	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public Criteria getCri() {
		return cri;
	}


	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
	
	
}
