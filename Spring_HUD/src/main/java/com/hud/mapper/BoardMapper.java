package com.hud.mapper;

import java.util.List;
import com.hud.model.BoardVo;
import com.hud.model.Criteria;

public interface BoardMapper {
	//전체 목록 리스트
	public List<BoardVo> boardList()throws Exception;
	//전체 목록 리스트(페이징 처리)
	public List<BoardVo>boardListPaging(Criteria cri)throws Exception;
	
	//board테이블의 전체갯수:페이징의 realEnd를 알기위해서
	public int boardCount(Criteria cri) throws Exception;
	//제목클릭 상세페이지
	public BoardVo boardDetail(int no) throws Exception;
	
	/* public void boardWrite(String subject,String content,String writer); */
	public void boardWrite(BoardVo board)throws Exception;
	public void boardModify(BoardVo board)throws Exception;
	public void boardDel(BoardVo board)throws Exception;
	

	
	//조회수올리기	
	public boolean updateViewCnt(int no)throws Exception;
}
