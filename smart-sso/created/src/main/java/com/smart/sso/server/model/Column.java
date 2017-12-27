package com.smart.sso.server.model;



import com.smart.mvc.model.PersistentObject;

public class Column extends PersistentObject{

	private static final long serialVersionUID = 2089147595389365667L;

	private String columName;
	
	private String columAnnotation;
	
	private String columType;
	
	public String getColumName() {
		return columName;
	}
	public void setColumName(String columName) {
		this.columName = columName;
	}
	public String getColumAnnotation() {
		return columAnnotation;
	}
	public void setColumAnnotation(String columAnnotation) {
		this.columAnnotation = columAnnotation;
	}
	public String getColumType() {
		return columType;
	}
	public void setColumType(String columType) {
		this.columType = columType;
	}
	@Override
	public String toString() {
		return "Column [columName=" + columName + ", columAnnotation=" + columAnnotation + ", columType=" + columType
				+ "]";
	}
	
	
	
}
