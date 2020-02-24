package com.hud.mapper;

import com.hud.model.MessageVo;

public interface MessageMapper {
	
	public void create(MessageVo vo) throws Exception;
	
	public MessageVo readMessage(int mid)throws Exception;
	
	public void updateState(int mid) throws Exception;

}
