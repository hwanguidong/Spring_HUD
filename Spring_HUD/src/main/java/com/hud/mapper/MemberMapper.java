package com.hud.mapper;

import com.hud.model.MemberVo;

public interface MemberMapper {
	public int check_id(String id) throws Exception;
	public int check_email(String email) throws Exception;
	public int join_member(MemberVo member) throws Exception;
	public int email_member(MemberVo member) throws Exception;
	public MemberVo login(String id) throws Exception;
	public int update_log(String id) throws Exception;
	public String find_id(String email) throws Exception;
	public int update_pw(MemberVo member)throws Exception;
	public int update_mypage(MemberVo member)throws Exception;
	public int delmem(MemberVo member)throws Exception;
}
