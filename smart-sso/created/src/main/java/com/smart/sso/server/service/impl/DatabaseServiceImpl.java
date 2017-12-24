package com.smart.sso.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.mvc.service.mybatis.impl.ServiceImpl;
import com.smart.sso.server.dao.DatabaseDao;
import com.smart.sso.server.model.DBTable;
import com.smart.sso.server.model.Database;
import com.smart.sso.server.service.DatabaseService;
@Service("databaseService")
public class DatabaseServiceImpl extends ServiceImpl<DatabaseDao, Database, Integer> implements DatabaseService{

	@Autowired
	@Override
	public void setDao(DatabaseDao dao) {
		this.dao = dao;
		
	}

	@Override
	public Database queryTablesBydbName(Database model) {
		
		return dao.queryTablesBydbName(model);
	}

	public DBTable queryColumnByTableName(DBTable model){
		
		return dao.queryColumnByTableName( model);
	}
	
	
}
