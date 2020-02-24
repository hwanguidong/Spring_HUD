package com.hud.service;

import java.util.List;


import com.hud.model.ReplyVo;

public interface ReplyService {
	//댓글 조회
	public List<ReplyVo> readReply(int no)throws Exception;
	
	//댓글작성
	public void writeReply(ReplyVo vo)throws Exception;
	
	//특정댓글 조회
	public ReplyVo readReplySelect(int rno)throws Exception;
		
	//댓글 수정
	public void replyUpdate(ReplyVo vo)throws Exception;
		
	//댓글 삭제
	public void replyDelete(ReplyVo vo)throws Exception;
	
	//아이디 체크 
	public String idCheck(int rno)throws Exception;
}
