package com.hud.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hud.model.BoardVo;
import com.hud.model.Criteria;
@Repository
public class BoardMapperImpl implements BoardMapper{
	
	@Autowired
	private SqlSession sqlSession;	
	private static final String namespace="com.hud.mapper.BoardMapper";

	//전체목록 리스트
	@Override
	public List<BoardVo> boardList() {
		List list=sqlSession.selectList(namespace+".boardList");
		return list;
	}
	//전체목록 리스트(페이징처리)
	@Override
	public List<BoardVo> boardListPaging(Criteria cri) throws Exception {
		List list=sqlSession.selectList(namespace+".boardListPage",cri);
		return list;
	}
	//제목클릭 상세페이지
	@Override
	public BoardVo boardDetail(int no)throws Exception 	{
		BoardVo boardvo=sqlSession.selectOne(namespace+".boardDetail",no);
		
		return boardvo;
	}

	@Override
	public void boardWrite(BoardVo board)throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("board",board);
		sqlSession.insert(namespace+".boardWrite",paramMap);
		
	}

	@Override
	public void boardModify(BoardVo board)throws Exception {
		sqlSession.update(namespace+".boardModify",board);
		
	}

	@Override
	public void boardDel(BoardVo board)throws Exception {
		sqlSession.delete(namespace+".boardDel",board);
		
	}
	@Override
	public int boardCount(Criteria cri) throws Exception {
		int cnt=sqlSession.selectOne(namespace+".boardCount",cri);
		return cnt;
	}
	
	@Override
	public boolean updateViewCnt(int no) throws Exception {
		sqlSession.update(namespace+".updateViewCnt",no);
		return false;
		
	}

	

}
