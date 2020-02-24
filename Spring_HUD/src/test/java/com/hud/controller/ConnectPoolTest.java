package com.hud.controller;

import java.sql.Connection;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class ConnectPoolTest {
	@Autowired 
	
	// DataSource dataSource=new DataSource();
	private DataSource dataSource;
@Autowired 
	
	// DataSource dataSource=new DataSource();
	private SqlSessionFactory sqlSessionFactory;
	@Test
	public void testConnetion() {
		try(	SqlSession session =sqlSessionFactory.openSession();
				Connection con = dataSource.getConnection()) {
			System.out.println("con="+con);
			System.out.println("sesstion="+session);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
