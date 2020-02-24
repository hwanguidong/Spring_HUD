package com.hud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hud.mapper.AdminMapper;
import com.hud.model.CategoryVo;
import com.hud.model.Criteria;
import com.hud.model.GoodsReplyListVo;
import com.hud.model.GoodsViewVo;
import com.hud.model.GoodsVo;
import com.hud.model.OrderListVo;
import com.hud.model.OrderVo;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper am;

	//상품등록
	@Override
	public void register(GoodsVo vo) throws Exception {
		am.register(vo);
		
	}
	//상품목록
	@Override
	public List<GoodsVo> goodlist() throws Exception {
		System.out.println("목록리스트오는지");
		return am.goodslist();
	}
	@Override
	public GoodsViewVo goodsView(int gdsNum) throws Exception {
		
		return am.goodsView(gdsNum);
	}
	@Override
	public void goodsModify(GoodsVo vo) throws Exception {
		am.goodsModify(vo);
		
	}
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		am.goodsDelete(gdsNum);
		
	}
	@Override
	public List<CategoryVo> category() throws Exception {
		
		return am.catetory();
	}
	@Override
	public List<OrderVo> orderList() throws Exception {
		// TODO Auto-generated method stub
		return am.orderList();
	}
	@Override
	public List<OrderListVo> orderView(OrderVo order) throws Exception {
		// TODO Auto-generated method stub
		return am.orderView(order);
	}
	@Override
	public void delivery(OrderVo order) throws Exception {
		am.delivery(order);
		
	}
	@Override
	public void changeStock(GoodsVo vo) throws Exception {
		am.changeStock(vo);
		
	}
	@Override
	public List<GoodsReplyListVo> allReply() throws Exception {
		
		return am.allReply();
	}
	@Override
	public void deleteReply(int repNum) throws Exception {
		am.deleteReply(repNum);
		
	}
	@Override
	public List<GoodsVo> goodslistPaging(Criteria cri) throws Exception {
		
		return am.goodslistPaging(cri);
	}
	@Override
	public int goodsCount(Criteria cri) throws Exception {
		
		return am.goodsCount(cri);
	}

}
