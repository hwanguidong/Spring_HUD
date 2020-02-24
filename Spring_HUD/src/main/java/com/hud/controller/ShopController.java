package com.hud.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hud.model.CartListVo;
import com.hud.model.CartVo;
import com.hud.model.GoodsReplyListVo;
import com.hud.model.GoodsReplyVo;
import com.hud.model.GoodsViewVo;
import com.hud.model.MemberVo;
import com.hud.model.OrderDetailVo;
import com.hud.model.OrderListVo;
import com.hud.model.OrderVo;
import com.hud.service.ShopService;

@Controller
@RequestMapping("/shop/*")
public class ShopController {
	@Autowired
	private ShopService shopservice;
	private static final Logger logger=LoggerFactory.getLogger(AdminController.class);
	
	
	
	
	
	//카테고리별 상품리스트
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public void getList(@RequestParam("c")int cateCode,
						@RequestParam("l")int level,Model model)throws Exception{
		
		logger.info("get llist");
		
		List<GoodsViewVo>list=null;
		list =shopservice.list(cateCode, level);
		
		model.addAttribute("list",list);
		System.out.println(list);
	}
	
	//상품조회
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public void getView(@RequestParam("n") int gdsNum,Model model)throws Exception{
		logger.info("get view");
		
		GoodsViewVo view =shopservice.goodsView(gdsNum);
		model.addAttribute("view",view);
		
		/*
		 * List<GoodsReplyListVo> reply = shopservice.replyList(gdsNum);
		 * model.addAttribute("reply", reply);
		 */
	}
	
	// 상품 조회 - 소감(댓글) 작성
	/*
	 * @RequestMapping(value = "/view", method = RequestMethod.POST) public String
	 * registReply(GoodsReplyVo reply, HttpSession session) throws Exception {
	 * logger.info("regist reply");
	 * 
	 * MemberVo member = (MemberVo)session.getAttribute("member");
	 * reply.setUserId(member.getId());
	 * 
	 * shopservice.registReply(reply);
	 * 
	 * return "redirect:/shop/view?n=" + reply.getGdsNum(); }
	 */
	
	// 상품 소감(댓글) 작성(ajax)
	@ResponseBody
	@RequestMapping(value = "/view/registReply", method = RequestMethod.POST)
	public void registReply(GoodsReplyVo reply,  HttpSession session) throws Exception {
	 logger.info("regist reply");
	 
	 MemberVo member = (MemberVo)session.getAttribute("member");
	 reply.setUserId(member.getId());
	 
	 shopservice.registReply(reply);
	} 
	
	// 상품 소감(댓글) 목록
	@ResponseBody
	@RequestMapping(value = "/view/replyList", method = RequestMethod.GET)
	public List<GoodsReplyListVo> getReplyList(@RequestParam("n") int gdsNum) throws Exception {
	 logger.info("get reply list");
	   
	 List<GoodsReplyListVo> reply = shopservice.replyList(gdsNum);
	 
	 return reply;
	}
	
	// 상품 소감(댓글) 삭제
	@ResponseBody
	@RequestMapping(value = "/view/deleteReply", method = RequestMethod.POST)
	public int getReplyList(GoodsReplyVo reply,  HttpSession session) throws Exception {
	 logger.info("post delete reply");

	 int result = 0;
	 
	 MemberVo member = (MemberVo)session.getAttribute("member");
	 String userId = shopservice.idCheck(reply.getRepNum());
	   
	 if(member.getId().equals(userId)) {
	  
	  reply.setUserId(member.getId());
	  shopservice.deleteReply(reply);
	  System.out.println(userId);
	  System.out.println(reply);
	  result = 1;
	 }
	 
	 return result; 
	}
	
	
	// 상품 소감(댓글) 수정
	@ResponseBody
	@RequestMapping(value = "/view/modifyReply", method = RequestMethod.POST)
	public int modifyReply(GoodsReplyVo reply, HttpSession session) throws Exception {
	 logger.info("modify reply");
	 
	 int result = 0;
	 
	 MemberVo member = (MemberVo)session.getAttribute("member");
	 String userId = shopservice.idCheck(reply.getRepNum());
	 
	 if(member.getId().equals(userId)) {
	  
	  reply.setUserId(member.getId());
	  shopservice.modifyReply(reply);
	  result = 1;
	 }
	 
	 return result;
	} 
	
	
	// 카트 담기
	@ResponseBody
	@RequestMapping(value = "/view/addCart", method = RequestMethod.POST)
	public int addCart(CartVo cart, HttpSession session) throws Exception {
	 
	 int result = 0;
	 
	 MemberVo member = (MemberVo)session.getAttribute("member");
	 
	 if(member != null) {
	  cart.setUserId(member.getId());
	  shopservice.addCart(cart);
	  result = 1;
	 }
	 
	 return result;
	}
	 
	// 카트 목록
	@RequestMapping(value = "/cartList", method = RequestMethod.GET)
	public void getCartList(HttpSession session, Model model) throws Exception {
	 logger.info("get cart list");
	 
	 MemberVo member = (MemberVo)session.getAttribute("member");
	 String userId = member.getId();
	 
	 List<CartListVo> cartList = shopservice.cartList(userId);
	 
	 model.addAttribute("cartList", cartList);
	 
	}
	
	// 카트 삭제
	@ResponseBody
	@RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
	public int deleteCart(HttpSession session,
	     @RequestParam(value = "chbox[]") List<String> chArr, CartVo cart) throws Exception {
	 logger.info("delete cart");
	 
	 MemberVo member = (MemberVo)session.getAttribute("member");
	 String userId = member.getId();
	 
	 int result = 0;
	 int cartNum = 0;
	 
	 
	 if(member != null) {
	  cart.setUserId(userId);
	  
	  for(String i : chArr) {   
	   cartNum = Integer.parseInt(i);
	   cart.setCartNum(cartNum);
	   shopservice.deleteCart(cart);
	  }   
	  result = 1;
	 }  
	 return result;  
	}
	
	// 주문
	@RequestMapping(value = "/cartList", method = RequestMethod.POST)
	public String order(HttpSession session, OrderVo order, OrderDetailVo orderDetail) throws Exception {
	 logger.info("order");
	 
	 MemberVo member = (MemberVo)session.getAttribute("member");  
	 String userId = member.getId();
	 
	 Calendar cal = Calendar.getInstance();
	 int year = cal.get(Calendar.YEAR);
	 String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
	 String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
	 String subNum = "";
	 
	 for(int i = 1; i <= 6; i ++) {
	  subNum += (int)(Math.random() * 10);
	 }
	 
	 String orderId = ymd + "_" + subNum;
	 
	 order.setOrderId(orderId);
	 order.setUserId(userId);
	  
	 shopservice.orderInfo(order);
	 
	 orderDetail.setOrderId(orderId);   
	 shopservice.orderInfo_Details(orderDetail);
	 
	 shopservice.cartAllDelete(userId);
	 
	 return "redirect:/shop/orderList";  
	}
	
	// 주문 목록
	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
	public void getOrderList(HttpSession session, OrderVo order, Model model) throws Exception {
	 logger.info("get order list");
	 
	 MemberVo member = (MemberVo)session.getAttribute("member");
	 String userId = member.getId();
	 
	 order.setUserId(userId);
	 
	 List<OrderVo> orderList = shopservice.orderList(order);
	 
	 model.addAttribute("orderList", orderList);
	}
	
	// 주문 상세 목록
	@RequestMapping(value = "/orderView", method = RequestMethod.GET)
	public void getOrderList(HttpSession session,
	      @RequestParam("n") String orderId,
	      OrderVo order, Model model) throws Exception {
	 logger.info("get order view");
	 
	 MemberVo member = (MemberVo)session.getAttribute("member");
	 String userId = member.getId();
	 
	 order.setUserId(userId);
	 order.setOrderId(orderId);
	 
	 List<OrderListVo> orderView = shopservice.orderView(order);
	 
	 model.addAttribute("orderView", orderView);
	 
	 System.out.println(member);
	 System.out.println(orderView);
	 System.out.println(userId);
	 System.out.println(orderId);
	 
	 
	}
	
	
	
	
}
