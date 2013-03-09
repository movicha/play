package com.clouidio.test.db;

import com.clouidio.orm.api.base.anno.NoSqlIndexed;

public class AccountSuper {

	@NoSqlIndexed
	private int someField;
	@NoSqlIndexed
	private Boolean isActive;
	
	public int getSomeField() {
		return someField;
	}

	public void setSomeField(int someField) {
		this.someField = someField;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean indexedColumn) {
		this.isActive = indexedColumn;
	}
	
}
