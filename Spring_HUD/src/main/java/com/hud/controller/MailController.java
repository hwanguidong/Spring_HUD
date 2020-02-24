package com.hud.controller;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hud.model.MailVo;

@Controller

public class MailController {
	private static final Logger Logger=	LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="mail",method=RequestMethod.GET)
	public void mailSendingGet() {
		Logger.info("mail.jsp실행.");
	}
	
	@RequestMapping(value="mail",method=RequestMethod.POST)
	public void mailSending(MailVo mail) {
		Logger.info("tomail"+mail.getTo());
		Logger.info("title"+mail.getTitle());
		Logger.info("content"+mail.getContent());
		Logger.info("from"+mail.getFrom());
		try {
			 
			
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper messageHelper=new MimeMessageHelper(message,true,"utf-8");
			
			messageHelper.setFrom(mail.getFrom());//보내는 사람(생략하면 정상적으로 작동x)
			messageHelper.setTo(mail.getTo());//받는사람
			messageHelper.setSubject(mail.getTitle());//메일제목(생략가능)
			messageHelper.setText(mail.getContent());//메일 내용
			
			mailSender.send(message);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
