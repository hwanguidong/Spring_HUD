package com.hud.service;

import java.util.List;

import com.hud.model.BoardVo;
import com.hud.model.Criteria;

public interface BoardService {
		//게시판리스트
	public List<BoardVo> listAll() throws Exception;
	//게시판리스트
	public List<BoardVo> boardListPaging(Criteria cri) throws Exception;	
		//게시판 제목을 클릭했을때
	public BoardVo boardDetail(int no) throws Exception;	
		//게시판 글수정
	public void boardModify(BoardVo board)throws Exception;
		//게시판 글삭제
	public void boardDel(BoardVo board)throws Exception;
		//게시판 글쓰기
	public void boardWrite(BoardVo board)throws Exception;
	//board테이블의 전체갯수:페이징의 realEnd를 알기위해서
	public int boardCount(Criteria cri) throws Exception;
	//조회수
	public boolean updateViewCnt(int no)throws Exception;
	
}
