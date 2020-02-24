package com.hud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hud.mapper.MessageMapper;
import com.hud.mapper.PointMapper;
import com.hud.model.MessageVo;

@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageMapper mm;
	@Autowired
	private PointMapper pm;
	
	@Transactional
	@Override
	public void addMessage(MessageVo vo) throws Exception {
		mm.create(vo);
		pm.updatePoint(vo.getSender(),10);
		
	}

	@Override
	public MessageVo readMessage(String uid, int mid) throws Exception {
		mm.updateState(mid);
		pm.updatePoint(uid, 5);
		return mm.readMessage(mid);
	}

}
