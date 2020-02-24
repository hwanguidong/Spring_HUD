package com.hud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hud.model.CategoryVo;
import com.hud.model.Criteria;
import com.hud.model.GoodsReplyListVo;
import com.hud.model.GoodsViewVo;
import com.hud.model.GoodsVo;
import com.hud.model.OrderListVo;
import com.hud.model.OrderVo;


public interface AdminService {
	
	//상품등록
	@Autowired
	public void register(GoodsVo vo)throws Exception;
	
	//상품목록
	@Autowired
	public  List<GoodsVo>goodlist()throws Exception;
	
	//페이징상품
	public List<GoodsVo> goodslistPaging(Criteria cri)throws Exception;
		
	//상품테이블의 전체갯수:페이징의 realEnd를 알기위해서
	public int goodsCount(Criteria cri) throws Exception;
	
	//상품조회+카테고리 조인
	public GoodsViewVo goodsView(int gdsNum)throws Exception;
	
	//상품수정
	public void goodsModify(GoodsVo vo)throws Exception;
	
	//상품삭제
	public void goodsDelete(int gdsNum) throws Exception;
	
	//카테고리
	public List<CategoryVo>category()throws Exception;
	
	//주문목록
	public List<OrderVo>orderList()throws Exception;
	
	//특정주문목록
	public List<OrderListVo>orderView(OrderVo order)throws Exception;
		
	//배송상태
	public void delivery(OrderVo order)throws Exception;
	
	//상품수량 조절
	public void changeStock(GoodsVo vo)throws Exception;
	
	//모든소감(댓글)
	public List<GoodsReplyListVo>allReply()throws Exception;
	
	//소감(댓글) 삭제
	public void deleteReply(int repNum)throws Exception;
}
