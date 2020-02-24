package com.hud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hud.model.SampleVo;


@RestController
@RequestMapping("/sample")
public class RestSampleController {
	private static final Logger Logger =
			LoggerFactory.getLogger(RestSampleController.class);
	//단순 문자열 변환
	@RequestMapping(value="/hello",produces = "text/plain;charset=UTF-8")
	public String sayHello() {
		
		Logger.info("myme type:"+MediaType.TEXT_PLAIN_VALUE);
		return "Hello world키키";
		
		
	}
	@RequestMapping(value="/sendVo")
	public SampleVo sendVo() {
		SampleVo vo=new SampleVo();
		
		vo.setFirstName("황의");
		vo.setLastName("동");
		vo.setMno(123);
		return vo;
	}
	//컬렉션 (ArrayList)타입 객체변환
	@RequestMapping(value="/sendList")
	public List<SampleVo> sendList(){
		List<SampleVo>list=new ArrayList<>();
		for(int i=0;i<10;i++) {
			SampleVo vo=new SampleVo();
			vo.setFirstName("황의");
			vo.setLastName("동");
			vo.setMno(i);
			list.add(vo);
		}
		return list;
	}
	
	//컬렉션 (HashMap)타입 객체변환
	@RequestMapping(value="/sendMap")
	public Map<Integer,SampleVo> sendMap(){
		Map<Integer,SampleVo>map=new HashMap<>();
		for(int i=0;i<10;i++) {
			SampleVo vo=new SampleVo();
			vo.setFirstName("황의");
			vo.setLastName("동");
			vo.setMno(i);
			map.put(i,vo);
		}
		return map;
	}
	
	//@PathVariable :URL경로의 일부를 파라미터로 사용할떄 이용
	@RequestMapping(value="/member/{last}/{first}")
	public String[] getMember(@PathVariable("last")String last,@PathVariable("first")String first) {
		String[] member=new String[] {"lastname:"+last,"firstname"+first};
		return member;
		
	}
	
	
	//@RequestBody :JSON데이터를 원하는 타입의 객체로 변환해야하는경우에 주로 사용
	@RequestMapping(value="/memberRequestBody", method = RequestMethod.POST)
	public  SampleVo convert(@RequestBody SampleVo sv) {
		 Logger.info("member RequestBody.....="+sv);
		
		return sv;
		
	}
	
	
	
	
	
	
	
	
}
