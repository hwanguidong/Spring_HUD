package com.hud.mapper;

import java.util.List;

import com.hud.model.RepBoardVo;
import com.hud.model.Criteria;

public interface RepBoardMapper {
		//전체 목록 리스트
		public List<RepBoardVo> repboardList()throws Exception;
		//전체 목록 리스트(페이징 처리)
		public List<RepBoardVo>repboardListPaging(Criteria cri)throws Exception;
		
		//board테이블의 전체갯수:페이징의 realEnd를 알기위해서
		public int repboardCount(Criteria cri) throws Exception;
		//제목클릭 상세페이지
		public RepBoardVo repboardDetail(int no) throws Exception;
		
	
		public void repboardWrite(RepBoardVo board)throws Exception;
		public void repboardModify(RepBoardVo board)throws Exception;
		public void repboardDel(RepBoardVo board)throws Exception;
}
