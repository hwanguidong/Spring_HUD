package com.hud.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hud.mapper.BoardMapper;
import com.hud.mapper.TimeMapper;
import com.hud.model.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class BoardMapperTest {
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testBoardList() throws Exception {
	
		Logger.getLogger(""+boardMapper.boardList());
		
	
		
	}
	@Test
	public void testBoardDetail() throws Exception{
		BoardVo board=boardMapper.boardDetail(1);
		Logger.getLogger(""+board);
		
	}

	/*
	 * @Test public void testBoardWrite()throws Exception { 
	 * BoardVo board=new BoardVo();
	 * board.setSubject("제목입니다"); 
	 * board.setContent("내용입니다"); 
	 * board.setWriter("의동쓰");
	 * board.setCnt(1);
	 * 
	 * boardMapper.boardWrite(board);
	 * 
	 * }
	 */
	/*
	 * @Test public void testBoardModify() throws Exception{
	 *  BoardVo board=new BoardVo();
	 * board.setSubject("제목입니다"); 
	 * board.setContent("내용입니다"); 
	 * board.setNo(3);
	 * 
	 * boardMapper.boardModify(board); }
	 */
	@Test
	public void testBoardDel() throws Exception {
		BoardVo board=new BoardVo();
		
		board.setNo(6);
		
		boardMapper.boardDel(board);
	}
	
}
