package com.smart.sso.server.service;

import com.smart.mvc.service.mybatis.Service;
import com.smart.sso.server.model.DBTable;
import com.smart.sso.server.model.Database;

public interface DatabaseService extends Service<Database, Integer> {

	Database queryTablesBydbName(Database model);
	
	DBTable	queryColumnByTableName(DBTable model);
}
