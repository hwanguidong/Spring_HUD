package com.hud.service;

import com.hud.model.MessageVo;

public interface MessageService {
	public void addMessage(MessageVo vo) throws Exception;
		public MessageVo readMessage(String uid,int mid) throws Exception;
	
}
