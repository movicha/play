package com.clouidio.monitor.impl.db;

import com.clouidio.orm.api.base.anno.NoSqlEmbeddable;
import com.clouidio.orm.api.base.anno.NoSqlId;

@NoSqlEmbeddable
public class MonitorProperty {

	@NoSqlId
	private String key;
	
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
