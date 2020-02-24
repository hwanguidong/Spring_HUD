package com.hud.mapper;

import java.util.List;

import com.hud.model.CartListVo;
import com.hud.model.CartVo;
import com.hud.model.GoodsReplyListVo;
import com.hud.model.GoodsReplyVo;
import com.hud.model.GoodsViewVo;
import com.hud.model.OrderDetailVo;
import com.hud.model.OrderListVo;
import com.hud.model.OrderVo;

public interface ShopMapper {
	
	//카테고리별 상품 리스트:1차분류
	public List<GoodsViewVo>list(int cateCode,int cateCodeRef)throws Exception;
	
	//카테고리별 상품 리스트:2차분류
	public List<GoodsViewVo>list(int cateCode)throws Exception;
	
	//상품조회
	public GoodsViewVo goodsView(int gdsNum)throws Exception;
	
	//상품소감(댓글) 작성
	public void registReply(GoodsReplyVo reply)throws Exception;
	
	//상품소감(댓글) 리스트
	public List<GoodsReplyListVo> replyList(int gdsNum)throws Exception;
	
	//상품소감(댓글) 삭제
	public void deleteReply(GoodsReplyVo reply)throws Exception;
	
	//아이디 체크
	public String idCheck(int repNum)throws Exception;
	
	//상품소감(댓글)수정
	public void modifyReply(GoodsReplyVo reply)throws Exception;
	
	//카트 담기
	public void addCart(CartVo cart)throws Exception;
	
	//카트리스트
	public List<CartListVo> cartList(String userId)throws Exception;
	
	//카트삭제
	public void deleteCart(CartVo cart)throws Exception;
	
	//주문정보
	public void orderInfo(OrderVo order)throws Exception;
	
	//주문상세정보
	public void orderInfo_Details(OrderDetailVo orderDetail)throws Exception;
	
	//카트비우기
	public void cartAllDelete(String userId) throws Exception;
	
	//주문목록
	public List<OrderVo>orderList(OrderVo order)throws Exception;
	
	//특정주문 목록
	public List<OrderListVo>orderView(OrderVo order)throws Exception;
}
