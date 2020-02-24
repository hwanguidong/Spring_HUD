package com.hud.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hud.model.LoginVo;
import com.hud.model.UserVo;

@Repository
public class UserMapperImpl implements UserMapper{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace="com.hud.mapper.UserMapper";

	@Override
	public UserVo login(LoginVo log) throws Exception {
		UserVo user=sqlSession.selectOne(namespace+".login",log);
		return user;
	}

}
