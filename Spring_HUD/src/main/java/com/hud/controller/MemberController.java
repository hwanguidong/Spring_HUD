package com.hud.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hud.model.MemberVo;
import com.hud.service.MemberServiceImpl;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	
	
	
	
	//회원가입 폼 이동
	@RequestMapping(value="/memberJoinForm")
	public String memberJoinForm()throws Exception{
		return "/member/memberJoinForm";
		
	}
	@RequestMapping(value="/Memindex")
	public String Memberindex()throws Exception{
		return "/member/Memindex";
		
		
	}
	@Autowired
	private MemberServiceImpl service;

	// 아이디 중복 검사(AJAX)
	@RequestMapping(value = "/check_id.do", method = RequestMethod.POST)
	public void check_id(@RequestParam("id") String id, HttpServletResponse response) throws Exception{
		service.check_id(id, response);
	}
	
	// 이메일 중복 검사(AJAX)
	@RequestMapping(value = "/check_email.do", method = RequestMethod.POST)
	public void check_email(@RequestParam("email") String email, HttpServletResponse response) throws Exception{
		service.check_email(email, response);
	}
	
	// 회원 가입
	@RequestMapping(value = "/join_member.do", method = RequestMethod.POST)
	public String join_member(@ModelAttribute MemberVo member, RedirectAttributes rttr, HttpServletResponse response) throws Exception{
		
		System.out.println("join_member오는지");
		rttr.addFlashAttribute("result", service.join_member(member, response));
		return "redirect:./memberJoinForm";
	}
	// 회원 인증
	@RequestMapping(value = "/email_member.do", method = RequestMethod.POST)
	public void email_member(@ModelAttribute MemberVo member, HttpServletResponse response) throws Exception{
		service.email_member(member, response);
	}
	// 로그인 폼 이동
		@RequestMapping(value = "/login_form.do", method = RequestMethod.GET)
		public String login_form() throws Exception{
			return "/member/login_form";
		}
		
		// 로그인
		@RequestMapping(value = "/login.do", method = RequestMethod.POST)
		public String login(@ModelAttribute MemberVo member, HttpSession session, HttpServletResponse response) throws Exception{
			member = service.login(member, response);
			session.setAttribute("member", member);
			System.out.println(session);
			return "redirect:/homepage";
		}
	
		// 로그아웃
		@RequestMapping(value = "/logout.do", method = {RequestMethod.GET,RequestMethod.POST})
		public void logout(HttpSession session, HttpServletResponse response) throws Exception{
			System.out.println(session);
			session.invalidate();
			//session.removeAttribute("member");
			service.logout(response);
			System.out.println(session);
			System.out.println("========");
			
		}
		
		// 아이디 찾기 폼
		@RequestMapping(value = "/find_id_form.do")
		public String find_id_form() throws Exception{
			return "/member/find_id_form";
		}
		
		// 아이디 찾기
		@RequestMapping(value = "/find_id.do", method = RequestMethod.POST)
		public String find_id(HttpServletResponse response, @RequestParam("email") String email, Model md) throws Exception{
			md.addAttribute("id", service.find_id(response, email));
			return "/member/find_id";
		}
		
		// 비밀번호 찾기 폼
		@RequestMapping(value = "/find_pw_form.do")
		public String find_pw_form() throws Exception{
			return "/member/find_pw_form";
		}
		
		// 비밀번호 찾기
		@RequestMapping(value = "/find_pw.do", method = RequestMethod.POST)
		public void find_pw(@ModelAttribute MemberVo member, HttpServletResponse response) throws Exception{
			service.find_pw(response, member);
		}
		// 마이페이지 이동
		@RequestMapping(value = "/mypage.do")
		public String mypage() throws Exception{
			return "/member/mypage";
		}
		
		// mypage 수정
		@RequestMapping(value = "/update_mypage.do", method = RequestMethod.POST)
		public String update_mypage(@ModelAttribute MemberVo member, HttpSession session, RedirectAttributes rttr) throws Exception{
			session.setAttribute("member", service.update_mypage(member));
			rttr.addFlashAttribute("msg", "회원정보 수정 완료");
			return "redirect:./mypage.do";
		}
		
		// 비밀번호 변경
		@RequestMapping(value = "/update_pw.do", method = RequestMethod.POST)
		public String update_pw(@ModelAttribute MemberVo member, @RequestParam("old_pw") String old_pw, HttpSession session, HttpServletResponse response, RedirectAttributes rttr) throws Exception{
			session.setAttribute("member", service.update_pw(member, old_pw, response));
			rttr.addFlashAttribute("msg", "비밀번호 수정 완료");
			return "redirect:./login_form.do";
		}
		// 회원탈퇴
		@RequestMapping(value = "/delmem.do", method = RequestMethod.POST)
		public String delmem_form(@ModelAttribute MemberVo member, HttpSession session, HttpServletResponse response) throws Exception{
			if(service.delmem(member, response)) {
				session.invalidate();
			}
			return "Memindex";
			
		}

}
