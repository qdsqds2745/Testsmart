package com.smart.sso.server.enumeration;

public enum TypeEnum {

	INT("int","int") ,BIT("String","bit"),VARCHAR("String","varchar"),CHAR("String","char"),datetime("Date","datetime");
	
	
	private String javaType;
	
	private String dbType;


	
	public String getJavaType(String dbType){
		
		for (TypeEnum type : TypeEnum.values()) {
			
			if(type.equals(dbType)){
				
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
