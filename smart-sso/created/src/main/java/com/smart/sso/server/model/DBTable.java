package com.smart.sso.server.model;

import java.util.List;

import com.smart.mvc.model.PersistentObject;

public class DBTable extends PersistentObject{

	private static final long serialVersionUID = 1426741498220924490L;

	private String tableName;// 表名

	private String tableAnnotation; // 表注释

	private List<Column> colums; //列
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableAnnotation() {
		return tableAnnotation;
	}

	public void setTableAnnotation(String tableAnnotation) {
		this.tableAnnotation = tableAnnotation;
	}

	public List<Column> getColums() {
		return colums;
	}

	public void setColums(List<Column> colums) {
		this.colums = colums;
	}

	
}
