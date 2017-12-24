package com.smart.sso.server.dao;

import com.smart.mvc.dao.mybatis.Dao;
import com.smart.sso.server.model.DBTable;
import com.smart.sso.server.model.Database;

public interface DatabaseDao extends Dao<Database, Integer>{

	Database queryTablesBydbName(Database model);
	
	DBTable	queryColumnByTableName(DBTable model);
}
