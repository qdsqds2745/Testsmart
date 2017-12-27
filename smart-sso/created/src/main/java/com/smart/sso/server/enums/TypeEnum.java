package com.smart.sso.server.enums;

public enum TypeEnum {

	INT("int","int") ,BIT("boolean","bit"),VARCHAR("String","varchar"),CHAR("String","char"),datetime("String","datetime");
	
	
	private String javaType;
	
	private String dbType;


	
	public static String getJavaType(String dbType){
		
		for (TypeEnum type : TypeEnum.values()) {
			
			if(type.dbType.equals(dbType)){
				
				return type.javaType;
			}
		}
		
		return "String";
	}
	
	
	private TypeEnum(String javaType) {
		this.javaType = javaType;
	}



	private TypeEnum(String javaType, String dbType) {
		this.javaType = javaType;
		this.dbType = dbType;
	}

	private TypeEnum() {
	}
	
	
	
}
