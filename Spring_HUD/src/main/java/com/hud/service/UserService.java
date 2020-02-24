package com.hud.service;

import com.hud.model.LoginVo;
import com.hud.model.UserVo;

public interface UserService {
	
	public UserVo login(LoginVo log)throws Exception;

}
