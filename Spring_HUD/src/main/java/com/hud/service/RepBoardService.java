package com.hud.service;

import java.util.List;


import com.hud.model.Criteria;
import com.hud.model.RepBoardVo;

public interface RepBoardService {
	//게시판리스트
	public List<RepBoardVo> replistAll() throws Exception;
	//게시판리스트
	public List<RepBoardVo> repboardListPaging(Criteria cri) throws Exception;
	//댓글 조회
	public List<RepBoardVo>repboardList() throws Exception;
	//댓글 쓰기
	public void repboardWrite(RepBoardVo vo) throws Exception;
	//댓글 수정
	public void repboardModify(RepBoardVo vo) throws Exception;
	//댓글 삭제
	public void repboardDel(RepBoardVo vo) throws Exception;
	
	public int repboardCount(Criteria cri) throws Exception;
}
