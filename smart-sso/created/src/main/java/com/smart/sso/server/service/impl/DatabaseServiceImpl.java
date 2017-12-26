package com.smart.sso.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.mvc.service.mybatis.impl.ServiceImpl;
import com.smart.mvc.util.StringUtils;
import com.smart.sso.server.dao.DatabaseDao;
import com.smart.sso.server.model.DBTable;
import com.smart.sso.server.model.Database;
import com.smart.sso.server.service.DatabaseService;
import com.smart.sso.server.util.CreatedFileUtil;
@Service("databaseService")
public class DatabaseServiceImpl extends ServiceImpl<DatabaseDao, Database, Integer> implements DatabaseService{

	@Autowired
	@Override
	public void setDao(DatabaseDao dao) {
		this.dao = dao;
		
	}
	/**
	 * 根据数据库名查出所有表
	 */
	@Override
	public Database queryTablesBydbName(Database model) {
		
		return dao.queryTablesBydbName(model);
	}
	/**
	 * 根据表名查出所有字段和；类型 和注释
	 */
	@Override
	public DBTable queryColumnByTableName(DBTable model){
		
		return dao.queryColumnByTableName( model);
	}
	/**
	 * DBTable [tableName=null, tableAnnotation=null, 
	 * colums=[Column [columName=id, columAnnotation=, columType=int], 
	 * Column [columName=name, columAnnotation=名称, columType=varchar],
       Column [columName=sort, columAnnotation=排序, columType=int], 
       Column [columName=createTime, columAnnotation=创建时间, columType=datetime], 
       Column [columName=isEnable, columAnnotation=是否启用, columType=bit], 
       Column [columName=code, columAnnotation=编码, columType=varchar]]]

	 */
	/**
	 * 转入一个表的字段集合 生成相应的文件
	 */
	public void createdFile(DBTable dbTable,String path,String packagePath){
		String filePath = "D:/javaCreated/";
		String javaPackage = "com/tcb/created/model/";
		//dbTable 表
		//1.获取表名  生成类名
	      String javaName = StringUtils.captureName(dbTable.getTableName());
		
		//2生成Java类
	      CreatedFileUtil.createFile(new StringBuffer(filePath).append(javaPackage).toString(), javaName, "java");
		//3生成要写入的相关信息
		
		//4写入相关信息
		
		//
		//
		
		
		
	}
	
	
}
