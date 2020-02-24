package com.hud.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hud.model.CategoryVo;
import com.hud.model.GoodsReplyListVo;
import com.hud.model.GoodsReplyVo;
import com.hud.model.GoodsViewVo;
import com.hud.model.GoodsVo;
import com.hud.model.OrderListVo;
import com.hud.model.OrderVo;

import com.hud.service.AdminService;
import com.hud.utils.UploadFileUtils;

import net.sf.json.JSONArray;






@Controller
@RequestMapping("/admin/*")
public class AdminController {
	@Autowired
	private AdminService adminservice;
	
	private static final Logger logger=LoggerFactory.getLogger(AdminController.class);
	
	@Resource(name="uploadPath")
	private String uploadPath;
			
	//관리자화면
	@RequestMapping(value ="/index",method = RequestMethod.GET)
	public void getIndex()throws Exception{
		
	}
	
	//상품등록
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception {
		 logger.info("get goods register");
		 List<CategoryVo>category=null;
		 category =adminservice.category();
		 model.addAttribute("category",JSONArray.fromObject(category));
		 System.out.println(JSONArray.fromObject(category));
		}
	
	//상품등록
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String postGoodsRegister(GoodsVo vo,MultipartFile file) throws Exception {
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		String aa=File.separator + "imgUpload" + ymdPath + File.separator + fileName;
		
		vo.setGdsImg(aa.substring(ymdPath.length()).replace(File.separatorChar, '/'));
		
		String bb=File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName;
		
		vo.setGdsThumbImg(bb.substring(ymdPath.length()).replace(File.separatorChar, '/'));
		adminservice.register(vo);
		
		System.out.println("이미지 불러오는지");
		
		return"redirect:/admin/index";
		
		}
	
	//상품목록
		@RequestMapping(value="/list", method = RequestMethod.GET)
		public void getGoodsList(Model model) throws Exception {
			 logger.info("get goods list");
			 
			 List<GoodsVo>list=adminservice.goodlist();
			 model.addAttribute("list",list);
			}
		
		
		
	//상품목록
		@RequestMapping(value="/view",method=RequestMethod.GET)
		public void getGoodsview(@RequestParam("n")int gdsNum,Model model) throws Exception {
			 logger.info("get goods view");
			 GoodsViewVo goods =adminservice.goodsView(gdsNum);
			 model.addAttribute("goods",goods);
		}
	//상품수정
		@RequestMapping(value="/modify",method=RequestMethod.GET)
		public void getGoodsModify(@RequestParam("n")int gdsNum,Model model) throws Exception {
			 logger.info("get goods modify");
			 
			 GoodsViewVo goods =adminservice.goodsView(gdsNum);
			 model.addAttribute("goods",goods);
			 
			 List<CategoryVo> category=null;
			 category=adminservice.category();
			 model.addAttribute("category",JSONArray.fromObject(category));
		}
	// 상품 수정
		@RequestMapping(value = "/modify", method = RequestMethod.POST)
		public String postGoodsModify(GoodsVo vo,MultipartFile file,HttpServletRequest req) throws Exception {
		 logger.info("post goods modify11");
		 
		// 새로운 파일이 등록되었는지 확인
		 if(file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) {
		  // 기존 파일을 삭제
		  new File(uploadPath + req.getParameter("gdsImg")).delete();
		  new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
		  
		  // 새로 첨부한 파일을 등록
		  String imgUploadPath = uploadPath + File.separator + "imgUpload";
		  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		  
		  
		  String aa=File.separator + "imgUpload" + ymdPath + File.separator + fileName;
			
			vo.setGdsImg(aa.substring(ymdPath.length()).replace(File.separatorChar, '/'));
			
			String bb=File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName;
			
			vo.setGdsThumbImg(bb.substring(ymdPath.length()).replace(File.separatorChar, '/'));
		 } else {  // 새로운 파일이 등록되지 않았다면
		  // 기존 이미지를 그대로 사용
		  vo.setGdsImg(req.getParameter("gdsImg"));
		  vo.setGdsThumbImg(req.getParameter("gdsThumbImg"));
		  System.out.println("이미지 그대로쓰는지==========");
		 }
		 System.out.println("수정오는지===========================");
		 adminservice.goodsModify(vo);
		 
		 return "redirect:/admin/index";
		}	
		
		// 상품 삭제
				@RequestMapping(value = "/delete", method = RequestMethod.POST)
				public String postGoodsDelete(@RequestParam("n")int gdsNum) throws Exception {
				 logger.info("post goods Del");

				 adminservice.goodsDelete(gdsNum);
				 
				 return "redirect:/admin/index";
				}	
				
				// 주문 목록
				@RequestMapping(value = "/orderList", method = RequestMethod.GET)
				public void getOrderList(Model model) throws Exception {
				 logger.info("get order list");
				   
				 List<OrderVo> orderList = adminservice.orderList();
				 
				 model.addAttribute("orderList", orderList);
				}

		// 주문 상세 목록
		@RequestMapping(value = "/orderView", method = RequestMethod.GET)
		public void getOrderList(@RequestParam("n") String orderId,
		     OrderVo order, Model model) throws Exception {
		logger.info("get order view");
				 
			 order.setOrderId(orderId);  
			 List<OrderListVo> orderView = adminservice.orderView(order);
				 
			 model.addAttribute("orderView", orderView);
		}
	
		// 주문 상세 목록 - 상태 변경
		@RequestMapping(value = "/orderView", method = RequestMethod.POST)
		public String delivery(OrderVo order) throws Exception {
		 logger.info("post order view");
		   
		 adminservice.delivery(order);
		 
		 List<OrderListVo> orderView = adminservice.orderView(order); 

		 GoodsVo vo = new GoodsVo();
		   
		 for(OrderListVo i : orderView) {
		  vo.setGdsNum(i.getGdsNum());
		  vo.setGdsStock(i.getCartStock());
		  adminservice.changeStock(vo);
		 }
		 
		 return "redirect:/admin/orderView?n=" + order.getOrderId();
		 
		}
	
		// 모든 소감(댓글)
		@RequestMapping(value = "/allReply", method = RequestMethod.GET)
		public void getAllReply(Model model) throws Exception {
		 logger.info("get all reply");
		   
		 List<GoodsReplyListVo> reply = adminservice.allReply();
		 
		 model.addAttribute("reply", reply);
		 
		 
		
		}
		
		//상품소감 삭제
		@RequestMapping(value="/allReply",method=RequestMethod.POST)
		public String postDeleteReply(GoodsReplyVo reply)throws Exception{
			 logger.info("deletereply");
			adminservice.deleteReply(reply.getRepNum());
			
			return "redirect:/admin/allReply";
			
			
		}
	
	
	
			
		
		
	        
	      
	    
	
	
	

}
