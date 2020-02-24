package com.hud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hud.model.Criteria;
import com.hud.model.GoodsVo;
import com.hud.model.PageVo;
import com.hud.service.AdminService;

@Controller

public class HomePageController {
	@Autowired
	private AdminService adminservice;
	
	private static final Logger logger=LoggerFactory.getLogger(AdminController.class);
	
	
	@RequestMapping(value="/homepage", method =RequestMethod.GET)
	public void homepage(Criteria cri,Model model) throws Exception{
		int total=adminservice.goodsCount(cri);
		PageVo pv=new PageVo(cri,total); 
		 List<GoodsVo>list=adminservice.goodlist(); 
		 
		 model.addAttribute("list",adminservice.goodslistPaging(cri));
		 model.addAttribute("page",pv);	
		 System.out.println("홈리스트오는지");
		
	}
	
}
