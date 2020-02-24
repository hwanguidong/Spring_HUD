package com.hud.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("select sysdate()")
	public String getTime();
	
	
	public String getTime1();
}
