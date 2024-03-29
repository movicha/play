package com.clouidio.orm.api.base;

import java.util.HashMap;
import java.util.Map;

public enum DbTypeEnum {
	CASSANDRA("cassandra"), IN_MEMORY("inmemory"), MONGODB("mongodb");
	
	private static final Map<String, DbTypeEnum> LOOKUP = new HashMap<String, DbTypeEnum>();
	
	//HADOOP
	static {
		for(DbTypeEnum type : DbTypeEnum.values()) {
			LOOKUP.put(type.getValue(), type);
		}
	}
	
	private String value;
	
	private DbTypeEnum(String val) {
		this.value = val;
	}

	private String getValue() {
		return value;
	}
	
	public static DbTypeEnum lookup(String val) {
		return LOOKUP.get(val);
	}
	
}
