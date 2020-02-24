package com.hud.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hud.model.MemberVo;



public class AdminInterceptor extends HandlerInterceptorAdapter {

	
//관리자가 아닌 사람이 주소만치고 들어오는것을 방지
 @Override
 public boolean preHandle(HttpServletRequest req,
    HttpServletResponse res, Object obj) throws Exception {
  
  HttpSession session = req.getSession();
  MemberVo member = (MemberVo)session.getAttribute("member");
  
  //로그인안했을때 홈페이지로 이동
  if(member == null) {
	  res.sendRedirect("/hud/homepage");
	  return false;
	 }
  //관리자가아닐때 홈페이지로 이동
  if( !(member.getHos()).equals("1") ) {
   res.sendRedirect("/hud/homepage");
   return false;
  }
  
  return true;
 }
}
