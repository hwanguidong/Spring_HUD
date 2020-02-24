package com.hud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hud.mapper.BoardMapper;
import com.hud.model.BoardVo;
import com.hud.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper bm;
	
	

	@Override
	public BoardVo boardDetail(int no) throws Exception {
		
		return bm.boardDetail(no);
	}

	@Override
	public void boardModify(BoardVo board) throws Exception {
		bm.boardModify(board);
		
	}

	@Override
	public void boardDel(BoardVo board) throws Exception {
		bm.boardDel(board);
		
	}
	@Transactional
	@Override
	public void boardWrite(BoardVo board) throws Exception {
		bm.boardWrite(board);
		
	
		
	}

	@Override
	public List<BoardVo> listAll() throws Exception {
		
		return bm.boardList();
	}

	@Override
	public List<BoardVo> boardListPaging(Criteria cri) throws Exception {
		return bm.boardListPaging(cri);
	}

	@Override
	public int boardCount(Criteria cri) throws Exception {
		
		return bm.boardCount(cri);
	}

	@Override
	public boolean updateViewCnt(int no) throws Exception {
		
		return bm.updateViewCnt(no);
	}

	

	
	

}
