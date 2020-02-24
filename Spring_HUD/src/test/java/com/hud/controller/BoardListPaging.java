package com.hud.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hud.model.BoardVo;
import com.hud.model.Criteria;
import com.hud.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class BoardListPaging {
	@Autowired
	private BoardService boardservice;
	
	@Test
	public void testPaging() throws Exception {
		Criteria cri=new Criteria();
		cri.setPageNum(2);
		cri.setAmount(10);
		List<BoardVo> list=boardservice.boardListPaging(cri);
		
		list.forEach(board->Logger.getLogger(""+board));
	}
	
	
}
