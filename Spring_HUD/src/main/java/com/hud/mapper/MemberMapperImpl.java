package com.hud.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hud.model.MemberVo;

@Repository
public class MemberMapperImpl implements MemberMapper {
	@Autowired
	private SqlSession sqlsession;
	private static final String namespace="com.hud.mapper.MemberMapper";
	
	public int check_id(String id) throws Exception{
		return sqlsession.selectOne(namespace+".check_id", id);
	}
	// 이메일 중복 검사
		public int check_email(String email) throws Exception{
			return sqlsession.selectOne(namespace+".check_email", email);
		}
		
		// 회원가입
		@Transactional
		public int join_member(MemberVo member) throws Exception{
			return sqlsession.insert(namespace+".join_member", member);
		}
		// 이메일 인증
		@Transactional
		public int email_member(MemberVo member) throws Exception{
			return sqlsession.update(namespace+".email_member", member);
		}
		//로그인 검사
		public MemberVo login(String id) throws Exception{
			return sqlsession.selectOne(namespace+".login",id);
		}
		//로그인 접속일자변경
		@Transactional
		public int update_log(String id)throws Exception{
			return sqlsession.update(namespace+".update_log",id);
		}
		// 아이디 찾기
		public String find_id(String email) throws Exception{
			return sqlsession.selectOne(namespace+".find_id", email);
		}
		// 비밀번호 변경
		@Transactional
		public int update_pw(MemberVo member) throws Exception{
			return sqlsession.update(namespace+".update_pw", member);
		}
		// 마이페이지
		@Transactional
		public int update_mypage(MemberVo member) throws Exception{
			return sqlsession.update(namespace+".update_mypage", member);
		}
		//회원탈퇴
		@Transactional
		public int delmem(MemberVo member)throws Exception{
			return sqlsession.delete(namespace+".delmem",member);
			
		}
}
