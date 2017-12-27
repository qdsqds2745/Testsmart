package com.smart.sso.server.util;

import java.io.File;

import com.smart.sso.server.enumeration.TypeEnum;
import com.smart.sso.server.model.Column;
import com.smart.sso.server.model.DBTable;

public class CreatedClassContentUtil {

	/**
	 * 根据表字段生成java类的的属性 get，set方法
	 * @return
	 */
	public static boolean  CreatedClassContent(String javaPackage,DBTable dbTable,String javaName){
		StringBuffer sb = new StringBuffer();
		sb.append("package ").append(delLastStr(javaPackage.replace(File.separator, "."))).append(";").append("\r\n");
		sb.append("\r\n");
//		for (Column column : dbTable.getColums()) {
//			if(column.getColumType().equals("Date")){
//				sb.append("import java.util.Date;\r\n");
//			}
//		}
		sb.append("public class ").append(javaName).append(" {\r\n");
		
		for (Column column : dbTable.getColums()) {
			System.out.println(column.getColumType()+"====>"+TypeEnum.getJavaType(column.getColumType()));
		 sb.append("     private ").append(TypeEnum.getJavaType(column.getColumType())).append(" ").append(column.getColumName()).append(";\r\n");		
			
		}
		
		
		
		
		
		sb.append("}");
		System.out.println(sb.toString());
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
