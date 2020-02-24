package com.hud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hud.mapper.ReplyMapper;
import com.hud.model.Criteria;
import com.hud.model.ReplyVo;


@Repository
public  class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyMapper rm;
	@Override
	public List<ReplyVo> readReply(int no) throws Exception {
		return rm.readReply(no);
	}
	@Override
	public void writeReply(ReplyVo vo) throws Exception {
		rm.writeReply(vo);
		
	}
	@Override
	public ReplyVo readReplySelect(int rno) throws Exception {
		
		return rm.readReplySelect(rno);
	}
	@Override
	public void replyUpdate(ReplyVo vo) throws Exception {
		rm.replyUpdate(vo);
		
	}
	@Override
	public void replyDelete(ReplyVo vo) throws Exception {
		rm.replyDelete(vo);
		
	}
	@Override
	public String idCheck(int rno) throws Exception {
	
		return rm.idCheck(rno);
	}

	

}
