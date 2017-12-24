package com.smart.sso.junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smart.sso.server.model.Database;
import com.smart.sso.server.service.DatabaseService;

public class DataBaseJUnit {
	
	private  static ApplicationContext ac = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void test() {
		
		fail("Not yet implemented");
	}
	@Test
	public void dataBase(){
		
		DatabaseService	databaseService  =	(DatabaseService) ac.getBean("databaseService");
		Database db = new Database();
		db.setDbName("smart-sso");
		Database db2 =	databaseService.queryTablesBydbName(db);
		System.out.println(db2);
		
	}
	
}
