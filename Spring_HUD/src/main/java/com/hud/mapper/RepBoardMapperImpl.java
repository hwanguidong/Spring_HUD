package com.hud.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hud.model.RepBoardVo;
import com.hud.model.Criteria;

@Repository
public class RepBoardMapperImpl implements RepBoardMapper {
	@Autowired
	private SqlSession sqlSession;	
	private static final String namespace="com.hud.mapper.RepBoardMapper";

	//전체목록 리스트
	@Override
	public List<RepBoardVo> repboardList() {
		List list=sqlSession.selectList(namespace+".repboardList");
		return list;
	}
	//전체목록 리스트(페이징처리)
	@Override
	public List<RepBoardVo> repboardListPaging(Criteria cri) throws Exception {
		List list=sqlSession.selectList(namespace+".repboardListPage",cri);
		return list;
	}
	//제목클릭 상세페이지
	@Override
	public RepBoardVo repboardDetail(int no)throws Exception 	{
		RepBoardVo boardvo=sqlSession.selectOne(namespace+".repboardDetail",no);
		
		return boardvo;
	}

	@Override
	public void repboardWrite(RepBoardVo vo)throws Exception {
		sqlSession.insert(namespace+".repboardWrite",vo);
		
	}

	@Override
	public void repboardModify(RepBoardVo vo)throws Exception {
		sqlSession.update(namespace+".repboardModify",vo);
		
	}

	@Override
	public void repboardDel(RepBoardVo vo)throws Exception {
		sqlSession.delete(namespace+".repboardDel",vo);
		
	}
	@Override
	public int repboardCount(Criteria cri) throws Exception {
		int cnt=sqlSession.selectOne(namespace+".repboardCount",cri);
		return cnt;
	}

}
