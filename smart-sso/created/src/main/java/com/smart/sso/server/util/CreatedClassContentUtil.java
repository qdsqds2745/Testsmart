package com.smart.sso.server.util;

import java.io.File;
import java.io.IOException;

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

		for (Column column : dbTable.getColums()) {
		sb.append("     public ").append(TypeEnum.getJavaType(column.getColumType())).append(" get").append(column.getColumName()).append("() {\r\n");
		sb.append("         return ").append(column.getColumName()).append(";\r\n");
		sb.append("     }\r\n");
		}
		/**
		 * public String getColumName() {
		return columName;
	}
	public void setColumName(String columName) {
		this.columName = columName;
	}
		 */
		
		sb.append("}");
		System.out.println(sb.toString());
		try {
			CreatedFileUtil.writeFileContent("D:\\javaCreated\\com\\tcb\\created\\model\\SysApp.java", sb.toString());
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
