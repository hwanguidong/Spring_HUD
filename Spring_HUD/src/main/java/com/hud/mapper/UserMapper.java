package com.hud.mapper;



import com.hud.model.LoginVo;
import com.hud.model.UserVo;

public interface UserMapper {
	
	public UserVo login(LoginVo log)throws Exception;

}

