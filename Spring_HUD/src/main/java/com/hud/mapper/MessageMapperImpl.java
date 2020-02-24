package com.hud.mapper;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hud.model.MessageVo;

@Repository
public class MessageMapperImpl implements MessageMapper {
	
	@Autowired
	private SqlSession session;
	private static final String namespace="com.hud.mapper.MessageMapper";
	
	@Override
	public void create(MessageVo vo) throws Exception {
		session.insert(namespace+".create",vo);
		
	}
	 
	

	@Override
	public MessageVo readMessage(int mid) throws Exception {
		
		return session.selectOne(namespace+".readMessage",mid);
	}

	@Override
	public void updateState(int mid) throws Exception {
		session.update(namespace+".updateState",mid);
		
	}

	
	
	

}
