package com.hud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.hud.mapper.RepBoardMapper;

import com.hud.model.Criteria;
import com.hud.model.RepBoardVo;

public class RepBoardServiceImpl implements RepBoardService{	

	@Autowired
	private RepBoardMapper rbm;

	@Override
	public List<RepBoardVo> replistAll() throws Exception {
		
		return rbm.repboardList();
	}

	@Override
	public List<RepBoardVo> repboardListPaging(Criteria cri) throws Exception {
		
		return rbm.repboardListPaging(cri);
	}

	@Override
	public List<RepBoardVo> repboardList() throws Exception {
		
		return rbm.repboardList();
	}

	@Override
	public void repboardWrite(RepBoardVo vo) throws Exception {
		rbm.repboardWrite(vo);
		
	}

	@Override
	public void repboardModify(RepBoardVo vo) throws Exception {
		rbm.repboardModify(vo);
		
	}

	@Override
	public void repboardDel(RepBoardVo vo) throws Exception {
		rbm.repboardDel(vo);
		
	}

	@Override
	public int repboardCount(Criteria cri) throws Exception {
		
		return rbm.repboardCount(cri);
	}
	

}
