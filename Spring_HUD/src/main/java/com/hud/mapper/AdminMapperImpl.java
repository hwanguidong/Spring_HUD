package com.hud.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hud.model.CategoryVo;
import com.hud.model.Criteria;
import com.hud.model.GoodsReplyListVo;
import com.hud.model.GoodsViewVo;
import com.hud.model.GoodsVo;
import com.hud.model.OrderListVo;
import com.hud.model.OrderVo;


@Repository
public class AdminMapperImpl implements  AdminMapper {
	
	@Autowired
	private SqlSession sqlsession;
	private static final String namespace="com.hud.mapper.AdminMapper";
	@Override
	public void register(GoodsVo vo) throws Exception {
		sqlsession.insert(namespace+".register",vo);
		
		
	}
	@Override
	public List<GoodsVo> goodslist() throws Exception {
		
		return sqlsession.selectList(namespace+".goodslist");
	}
	@Override
	public GoodsViewVo goodsView(int gdsNum) throws Exception {
		
		return sqlsession.selectOne(namespace+".goodsView",gdsNum);
	}
	@Override
	public void goodsModify(GoodsVo vo) throws Exception {
		sqlsession.update(namespace+".goodsModify",vo);
		
	}
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		sqlsession.delete(namespace+".goodsDelete",gdsNum);
		
	}
	@Override
	public List<CategoryVo> catetory() throws Exception {
		
		return sqlsession.selectList(namespace+".category");
	}
	@Override
	public List<OrderVo> orderList() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".orderList");
	}
	@Override
	public List<OrderListVo> orderView(OrderVo order) throws Exception {
		
		return sqlsession.selectList(namespace+".orderView",order);
	}
	@Override
	public void delivery(OrderVo order) throws Exception {
		sqlsession.update(namespace+".delivery",order);
		
	}
	@Override
	public void changeStock(GoodsVo vo) throws Exception {
		sqlsession.update(namespace+".changeStock",vo);
		
	}
	@Override
	public List<GoodsReplyListVo> allReply() throws Exception {
		
		return sqlsession.selectList(namespace+".allReply");
	}
	@Override
	public void deleteReply(int repNum) throws Exception {
		sqlsession.delete(namespace+".deleteReply",repNum);
		
	}
	@Override
	public List<GoodsVo> goodslistPaging(Criteria cri) throws Exception {
		List list=sqlsession.selectList(namespace+".goodsListPage",cri);
		return list;
	}
	@Override
	public int goodsCount(Criteria cri) throws Exception {
		int cnt=sqlsession.selectOne(namespace+".goodsCount",cri);
		return cnt;
	}

}
