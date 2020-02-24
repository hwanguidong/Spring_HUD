package com.hud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hud.mapper.UserMapper;

import com.hud.model.LoginVo;
import com.hud.model.UserVo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper um;
		
	@Override
	public UserVo login(LoginVo log) throws Exception {
		
		return um.login(log);
	}

}
