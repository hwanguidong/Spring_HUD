package com.hud.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hud.model.CartListVo;
import com.hud.model.CartVo;
import com.hud.model.GoodsReplyListVo;
import com.hud.model.GoodsReplyVo;
import com.hud.model.GoodsViewVo;
import com.hud.model.OrderDetailVo;
import com.hud.model.OrderListVo;
import com.hud.model.OrderVo;

@Repository
public class ShopMapperImpl implements ShopMapper {
	
	@Autowired
	private SqlSession sqlsession;
	private static final String namespace="com.hud.mapper.ShopMapper";

	// 카테고리별 상품 리스트 : 1차 분류
	@Override
	public List<GoodsViewVo> list(int cateCode, int cateCodeRef) throws Exception {
	 
	 HashMap<String, Object> map = new HashMap<String, Object>();
	 
	 map.put("cateCode", cateCode);
	 map.put("cateCodeRef", cateCodeRef);
	 
	 return sqlsession.selectList(namespace + ".list_1", map);
	}

	// 카테고리별 상품 리스트 : 2차 분류
	@Override
	public List<GoodsViewVo> list(int cateCode) throws Exception {
	 
	 return sqlsession.selectList(namespace + ".list_2", cateCode);
	}

	@Override
	public GoodsViewVo goodsView(int gdsNum) throws Exception {
		
		return sqlsession.selectOne("com.hud.mapper.AdminMapper"+".goodsView",gdsNum);
	}

	@Override
	public void registReply(GoodsReplyVo reply) throws Exception {
		sqlsession.insert(namespace+".registReply",reply);
		
	}

	@Override
	public List<GoodsReplyListVo> replyList(int gdsNum) throws Exception {
		
		return sqlsession.selectList(namespace+".replyList",gdsNum);
	}

	@Override
	public void deleteReply(GoodsReplyVo reply) throws Exception {
		sqlsession.delete(namespace+".deleteReply",reply);
		
	}

	@Override
	public String idCheck(int repNum) throws Exception {
		
		return sqlsession.selectOne(namespace+".replyUserIdCheck",repNum);
	}

	@Override
	public void modifyReply(GoodsReplyVo reply) throws Exception {
		sqlsession.update(namespace+".modifyReply",reply);
		
	}

	@Override
	public void addCart(CartVo cart) throws Exception {
		sqlsession.insert(namespace+".addCart",cart);
		
	}

	@Override
	public List<CartListVo> cartList(String userId) throws Exception {
		
		return sqlsession.selectList(namespace+".cartList",userId);
	}

	@Override
	public void deleteCart(CartVo cart) throws Exception {
		sqlsession.delete(namespace+".deleteCart",cart);
		
	}

	@Override
	public void orderInfo(OrderVo order) throws Exception {
		sqlsession.insert(namespace+".orderInfo",order);
		
	}

	@Override
	public void orderInfo_Details(OrderDetailVo orderDetail) throws Exception {
		sqlsession.insert(namespace+".orderInfo_Details",orderDetail);
		
	}

	@Override
	public void cartAllDelete(String userId) throws Exception {
		sqlsession.delete(namespace+".cartAllDelete",userId);
		
	}

	@Override
	public List<OrderVo> orderList(OrderVo order) throws Exception {
		
		return sqlsession.selectList(namespace+".orderList",order);
	}

	@Override
	public List<OrderListVo> orderView(OrderVo order) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".orderView",order);
	}

}
