package com.smart.sso.server.model;

import java.util.List;

import com.smart.mvc.model.PersistentObject;


public class Database extends PersistentObject{

	private static final long serialVersionUID = 6945033041259506188L;

	private String dbName; //数据库名
	
	private List<DBTable>  tables;//表名

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public List<DBTable> getTables() {
		return tables;
	}

	public void setTables(List<DBTable> tables) {
		this.tables = tables;
	}
	
	
	  
}
