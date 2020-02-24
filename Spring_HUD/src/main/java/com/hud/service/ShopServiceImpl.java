package com.hud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hud.mapper.ShopMapper;
import com.hud.model.CartListVo;
import com.hud.model.CartVo;
import com.hud.model.GoodsReplyListVo;
import com.hud.model.GoodsReplyVo;
import com.hud.model.GoodsViewVo;
import com.hud.model.OrderDetailVo;
import com.hud.model.OrderListVo;
import com.hud.model.OrderVo;
@Service
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	private ShopMapper sm;

	@Override
	public List<GoodsViewVo> list(int cateCode,int level) throws Exception {
		int cateCodeRef = 0;  // 카테고리 참조 코드. 없어도 무관
		 
		 if(level == 1) {  // lavel 1 = 1차 분류.
		  
		  cateCodeRef = cateCode;
		  return sm.list(cateCode, cateCodeRef);
		  // 두가지 모두 cateCode로 해도 무관
		  
		 } else {  // lavel 2 = 2차 분류
		  
		  return sm.list(cateCode);
		  
		 }
		 
		}

	@Override
	public GoodsViewVo goodsView(int gdsNum) throws Exception {
		
		return sm.goodsView(gdsNum);
	}

	@Override
	public void registReply(GoodsReplyVo reply) throws Exception {
		sm.registReply(reply);
		
	}

	@Override
	public List<GoodsReplyListVo> replyList(int gdsNum) throws Exception {
		
		return sm.replyList(gdsNum);
	}

	@Override
	public void deleteReply(GoodsReplyVo reply) throws Exception {
		sm.deleteReply(reply);
		
	}

	@Override
	public String idCheck(int repNum) throws Exception {
		
		return sm.idCheck(repNum);
	}

	@Override
	public void modifyReply(GoodsReplyVo reply) throws Exception {
		sm.modifyReply(reply);
		
	}

	@Override
	public void addCart(CartVo cart) throws Exception {
		sm.addCart(cart);
		
	}

	@Override
	public List<CartListVo> cartList(String userId) throws Exception {
		
		return sm.cartList(userId);
	}

	@Override
	public void deleteCart(CartVo cart) throws Exception {
		sm.deleteCart(cart);
		
	}

	@Override
	public void orderInfo(OrderVo order) throws Exception {
		sm.orderInfo(order);
		
	}

	@Override
	public void orderInfo_Details(OrderDetailVo orderDetail) throws Exception {
		sm.orderInfo_Details(orderDetail);
		
	}

	@Override
	public void cartAllDelete(String userId) throws Exception {
		sm.cartAllDelete(userId);
		
	}

	@Override
	public List<OrderVo> orderList(OrderVo order) throws Exception {
		
		return sm.orderList(order);
	}

	@Override
	public List<OrderListVo> orderView(OrderVo order) throws Exception {
		
		return sm.orderView(order);
	}

}
