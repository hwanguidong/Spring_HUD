package com.hud.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String LOGIN="login";
	/*
	 * preHandle :컨트롤러가 호출되가 전에 실행 
	 * postHandle: 컨트롤러가 실행된 후에 실행 
	 * afterComplete: 뷰에서 최종결과가 생성하는 일을 포함한 모든 일이 완료되었을때 실행
	 */
	//login한후(postHandle)
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler,ModelAndView mv)throws Exception{
		HttpSession session = request.getSession();
		
		Object UserVo=mv.getModelMap().get("UserVo");
		System.out.println("interceptor postHandle============"+UserVo);
		
		if(UserVo !=null) {//사용자가 회원가입했으면.
			//로그인 처리
			session.setAttribute(LOGIN, UserVo);//로그인 처리(session 회원정보 저장)
			response.sendRedirect("/hud");//로그인 성공한 후 메인페이지로 이동.
		}
		
	}
	//login하기전(preHandle
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception{
		
		HttpSession session = request.getSession();
		if(session.getAttribute(LOGIN)!=null) {//기존에 로그인이 되어있다면,
			session.removeAttribute(LOGIN);//로그아웃
		}
		
				return true;
		
	}

}
