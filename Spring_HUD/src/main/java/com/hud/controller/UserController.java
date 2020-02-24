package com.hud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hud.model.LoginVo;
import com.hud.model.UserVo;
import com.hud.service.UserService;

@Controller
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserService uservice;
	private static final Logger Logger=	LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public void loginGET()throws Exception{
		
	}
	@RequestMapping(value="/loginPost",method=RequestMethod.POST)
	public void loginPOST(LoginVo log,Model model)throws Exception {
		UserVo user=uservice.login(log);
		if(user==null) {return;}
		model.addAttribute("UserVo",user);
	}

}
