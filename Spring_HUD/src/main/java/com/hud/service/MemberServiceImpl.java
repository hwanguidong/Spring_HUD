package com.hud.service;

import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hud.mapper.MemberMapper;

import com.hud.model.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberMapper mm;

	//아이디중복검사(ajax)
	@Override
	public void check_id(String id,HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		out.println(mm.check_id(id));
		out.close();
		
	}
	//이메일중복검사(ajax)
	@Override
	public  void check_email(String email,HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		out.println(mm.check_email(email));
		out.close();
		
	}
	@Override
	public String create_key() throws Exception {
		String key = "";
		Random rd = new Random();

		for (int i = 0; i < 8; i++) {
			key += rd.nextInt(10);
		}
		return key;
	}
	//회원가입
	@Override
	public int join_member(MemberVo member,HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();

		if (mm.check_id(member.getId()) == 1) {
			out.println("<script>");
			out.println("alert('동일한 아이디가 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else if (mm.check_email(member.getEmail()) == 1) {
			out.println("<script>");
			out.println("alert('동일한 이메일이 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else {
			member.setEmail_key(create_key());
			mm.join_member(member);
			//인증메일발송
			send_mail(member, "join");
			out.println("<script>");
			out.println("alert('이메일전송이완료되었습니다.');");			
			out.println("</script>");
			return 1;
		}
		
		
		
	}
	// 이메일 발송
	@Override
	public void send_mail(MemberVo member,String div) throws Exception {
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.naver.com";
		String hostSMTPid = "rnfnd2";
		String hostSMTPpwd = "uj6868";

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "rnfnd2@naver.com";
		String fromName = "HWANG SHOP Homepage";
		String subject = "HWANG SHOP 입니다.";
		String msg = "HWANG SHOP 가입을 축하드립니다.";
		
		if(div.equals("join")) {
		// 회원가입 메일 내용
		subject = "Spring Homepage 회원가입 인증 메일입니다.";
		msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
		msg += "<h3 style='color: blue;'>";
		msg += member.getId() + "님 회원가입을 환영합니다.</h3>";
		msg += "<div style='font-size: 130%'>";
		msg += "하단의 인증 버튼 클릭 시 정상적으로 회원가입이 완료됩니다.</div><br/>";
		msg += "<form method='post' action='http://localhost:8080/hud/member/email_member.do'>";
		msg += "<input type='hidden' name='email' value='" + member.getEmail() + "'>";
		msg += "<input type='hidden' name='email_key' value='" + member.getEmail_key() + "'>";
		msg += "<input type='submit' value='인증'></form><br/></div>";
		}else if(div.equals("find_pw")) {
			subject ="spring Homepage임시비밀번호";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += member.getId() + "님 의 임시비밀번호입니다. 비밀번호를 변경하세요.</h3>";
			msg += "<p>임시비밀번호:";
			msg += member.getPw()+"</p></div>";
		}
		// 받는 사람 E-Mail 주소
		String mail = member.getEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(587);

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}
	// 회원 인증
		@Override
		public void email_member(MemberVo member, HttpServletResponse response) throws Exception {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			System.out.println("메일접근");
			if (mm.email_member(member) == 0) { // 이메일 인증에 실패하였을 경우
				System.out.println("인증실패~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				out.println("<script>");
				out.println("alert('잘못된 접근입니다.');");
				out.println("history.go(-1);");	//이전페이지로 이동
				out.println("</script>");
				out.close();
			} else { // 이메일 인증을 성공하였을 경우
				out.println("<script>");
				out.println("alert('인증이 완료되었습니다. 로그인 후 이용하세요.');");
				out.println("location.href='../member/login_form.do';");
				out.println("</script>");
				out.close();
			}
		}
		
		
		// 로그인
		@Override
		public MemberVo login(MemberVo member, HttpServletResponse response) throws Exception {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			// 등록된 아이디가 없으면
			if(mm.check_id(member.getId()) == 0) {
				out.println("<script>");
				out.println("alert('등록된 아이디가 없습니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				return null;
			} else {
				String pw = member.getPw();
				member = mm.login(member.getId());
				// 비밀번호가 다를 경우
				if(!member.getPw().equals(pw)) {
					out.println("<script>");
					out.println("alert('비밀번호가 다릅니다.');");
					out.println("history.go(-1);");
					out.println("</script>");
					out.close();
					return null;
				// 이메일 인증을 하지 않은 경우
				}else if(!member.getEmail_status().equals("true")) {
					out.println("<script>");
					out.println("alert('이메일 인증 후 로그인 하세요.');");
					out.println("history.go(-1);");
					out.println("</script>");
					out.close();
					return null;
	            // 로그인 일자 업데이트 및 회원정보 리턴			
				}else {
					mm.update_log(member.getId());
					return member;
				}
			}
		}
		
		// 로그아웃
		@Override
		public void logout(HttpServletResponse response) throws Exception {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("location.href='../homepage';");
			out.println("</script>");
			out.close();
			
		}
		
		
		// 아이디 찾기
		@Override
		public String find_id(HttpServletResponse response, String email) throws Exception {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String id = mm.find_id(email);
			
			if (id == null) {
				out.println("<script>");
				out.println("alert('가입된 아이디가 없습니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				return null;
			} else {
				return id;
			}
		}
		
		
		// 비밀번호 찾기
		@Override
		public void find_pw(HttpServletResponse response, MemberVo member) throws Exception {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			// 아이디가 없으면
			if(mm.check_id(member.getId()) == 0) {
				out.print("아이디가 없습니다.");
				out.close();
			}
			// 가입에 사용한 이메일이 아니면
			else if(!member.getEmail().equals(mm.login(member.getId()).getEmail())) {
				out.print("잘못된 이메일 입니다.");
				out.close();
			}else {
				// 임시 비밀번호 생성
				String pw = "";
				for (int i = 0; i < 12; i++) {
					pw += (char) ((Math.random() * 26) + 97);
				}
				member.setPw(pw);
				// 비밀번호 변경
				mm.update_pw(member);
				// 비밀번호 변경 메일 발송
				send_mail(member, "find_pw");
				
				out.print("이메일로 임시 비밀번호를 발송하였습니다.");
				out.close();
			}
		}
		
		// 회원정보 수정
		@Override
		public MemberVo update_mypage(MemberVo member) throws Exception {
			mm.update_mypage(member);
			return mm.login(member.getId());
		}
		
		// 비밀번호 변경
		@Override
		public MemberVo update_pw(MemberVo member, String old_pw, HttpServletResponse response) throws Exception {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			if(!old_pw.equals(mm.login(member.getId()).getPw())) {
				out.println("<script>");
				out.println("alert('기존 비밀번호가 다릅니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				return null;
			}else {
				mm.update_pw(member);
				return mm.login(member.getId());
			}
		}
		
		
		// 회원탈퇴
		@Override
		public boolean delmem(MemberVo member, HttpServletResponse response) throws Exception {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			if(mm.delmem(member) != 1) {
				out.println("<script>");
				out.println("alert('회원탈퇴 실패');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				return false;
			}else {
				return true;
			}
		}

}
