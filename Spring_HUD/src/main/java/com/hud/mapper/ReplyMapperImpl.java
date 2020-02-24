package com.hud.mapper;


import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.hud.model.ReplyVo;

@Repository
public class ReplyMapperImpl implements ReplyMapper {
	@Autowired
	private SqlSession sqlSession;	
	private static  String namespace="com.hud.mapper.replyMapper";
	
	
	@Override
	public List<ReplyVo> readReply(int no) throws Exception {
		return sqlSession.selectList(namespace+".readReply",no);
		
	}


	@Override
	public void writeReply(ReplyVo vo) throws Exception {
		sqlSession.insert(namespace+".writeReply",vo);
		
	}


	@Override
	public ReplyVo readReplySelect(int rno) throws Exception {
	
		return sqlSession.selectOne(namespace+".readReplySelect",rno);
	}


	@Override
	public void replyUpdate(ReplyVo vo) throws Exception {
		sqlSession.update(namespace+".updateReply",vo);
		
	}


	@Override
	public void replyDelete(ReplyVo vo) throws Exception {
		sqlSession.delete(namespace+".deleteReply",vo);
		
	}


	@Override
	public String idCheck(int rno) throws Exception {
		
		return sqlSession.selectOne(namespace+".replywriterCheck",rno);
	}


	

}
