package com.hud.service;

import javax.servlet.http.HttpServletResponse;

import com.hud.model.MemberVo;

public interface MemberService {
	public void check_id(String id,HttpServletResponse response) throws Exception;

	public void check_email(String email,HttpServletResponse response) throws Exception;

	public int join_member(MemberVo member,HttpServletResponse response) throws Exception;

	String create_key() throws Exception;

	void send_mail(MemberVo member,String div) throws Exception;

	void email_member(MemberVo member, HttpServletResponse response) throws Exception;

	MemberVo login(MemberVo member, HttpServletResponse response) throws Exception;

	void logout(HttpServletResponse response) throws Exception;

	String find_id(HttpServletResponse response, String email) throws Exception;

	void find_pw(HttpServletResponse response, MemberVo member) throws Exception;

	MemberVo update_pw(MemberVo member, String old_pw, HttpServletResponse response) throws Exception;

	MemberVo update_mypage(MemberVo member) throws Exception;

	boolean delmem(MemberVo member, HttpServletResponse response) throws Exception;

	

	

	

	
}
