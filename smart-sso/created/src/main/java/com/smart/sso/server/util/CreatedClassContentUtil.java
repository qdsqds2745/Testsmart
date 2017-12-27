package com.smart.sso.server.util;

import java.io.File;
import java.io.IOException;

import com.smart.mvc.util.StringUtils;
import com.smart.sso.server.enums.TypeEnum;
import com.smart.sso.server.model.Column;
import com.smart.sso.server.model.DBTable;

public class CreatedClassContentUtil {

	/**
	 * 根据表字段生成java类的的属性 get，set方法
	 * @return
	 */
	public static boolean  CreatedClassContent(String javaPackage,DBTable dbTable,String javaName){
		StringBuffer sb = new StringBuffer();
		//引包
		sb.append("package ").append(delLastStr(javaPackage.replace(File.separator, "."))).append(";").append("\r\n");
		sb.append("\r\n");
         //生成类名
		sb.append("public class ").append(javaName).append(" {\r\n");
		//生成属性
		for (Column column : dbTable.getColums()) {
		    sb.append("     /**\r\n");
		    sb.append("     *").append(column.getColumAnnotation()).append("\r\n");
		    sb.append("     */\r\n");
			sb.append("     private ").append(TypeEnum.getJavaType(column.getColumType())).append(" ").append(column.getColumName()).append(";\r\n");		
			
		}
		//生成get set 方法
		sb.append("\r\r"); 
		for (Column column : dbTable.getColums()) {
		sb.append("     public ").append(TypeEnum.getJavaType(column.getColumType())).append(" get").append(StringUtils.firstCapital(column.getColumName())).append("() {\r\n");
		sb.append("         return ").append(column.getColumName()).append(";\r\n");
		sb.append("     }\r\r");
		sb.append("     public void set").append(StringUtils.firstCapital(column.getColumName())).append("(")
		      .append(TypeEnum.getJavaType(column.getColumType())).append(" ").append(column.getColumName()).append(") {\r\n");
		sb.append("         this.").append(column.getColumName()).append(" = ").append(column.getColumName()).append(";\r\n");
		sb.append("     }\r\r");
		}
		
		sb.append("}");
		
		try {
			CreatedFileUtil.writeFileContent("D:\\javaCreated\\com\\tcb\\created\\model\\SysApp.java", sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 根据表字段生成xml insert updata del select 方法
	 * @param javaPackage
	 * @param dbTable
	 * @param javaName
	 * @return
	 */
	public static boolean  CreatedMybatisXmlContent(String xmlPackage,DBTable dbTable,String javaName,String daoPackage){
		StringBuffer sb = new StringBuffer();
		//头文件
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r");
		sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >\r");
		//映射的dao
		sb.append("<mapper namespace=\"").append(daoPackage.replace(File.separator, ".")).append(javaName).append("Dao\">\r");
		
		sb.append("<select id=\"query\" parameterType=\"").append(javaName).append("\" resultMap=\"").append(javaName).append("\">\r");//resultMap="databaseMap" parameterType="Database">
		sb.append("select * from ").append(dbTable.getTableName()).append("\r");
		sb.append("</select>\r\r");
		sb.append("</mapper>");
		try {
			CreatedFileUtil.writeFileContent("D:\\javaCreated\\com\\tcb\\created\\mapper\\SysApp.xml", sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * 去掉最后一个字符
	 * @param str
	 * @return
	 */
	public static String delLastStr(String str){
		return str.substring(0,str.length()-1);
	}
}
