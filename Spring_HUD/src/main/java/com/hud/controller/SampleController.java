package com.hud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hud.model.SampleModel;
import com.hud.model.SampleVo;

@Controller
public class SampleController {
	
	private static final Logger Logger =
			LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("list")
	public String list() {
		return "board/list";
	}
	
	
}
