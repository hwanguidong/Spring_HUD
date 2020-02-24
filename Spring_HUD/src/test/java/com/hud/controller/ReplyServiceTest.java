package com.hud.controller;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.hud.model.ReplyVo;
import com.hud.service.ReplyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyServiceTest {
	@Autowired
	private ReplyService rbservice;
	
	/*
	 * @Test public void testrepServiceIns() throws Exception { ReplyVo rv=new
	 * ReplyVo(); rv.setBno(1); rv.setReplytext("댓글입니다잉"); rv.setReplyer("관리자");
	 * 
	 * rbservice.RepWrite(rv); }
	 */
	/*
	 * @Test public void testrepServiceUp() throws Exception { ReplyVo rv=new
	 * ReplyVo(); rv.setRno(1); rv.setReplytext("댓글수정입니다잉");
	 * 
	 * 
	 * rbservice.RepModify(rv); }
	 */
	/*
	 * @Test public void testrepServiceSe() throws Exception{ ReplyVo rv=new
	 * ReplyVo(); rv.setBno(1); rbservice.Replist(rv); }
	 */
	
	/*
	 * @Test public void testrepServiceSe() throws Exception{ ReplyVo rv=new
	 * ReplyVo(); rv.setRno(1); rbservice.RepDel(rv);
	 * 
	 * }
	 * 
	 */
	
}
