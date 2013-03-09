package com.clouidio.monitor.impl;

import java.util.Comparator;

import com.clouidio.monitor.impl.db.WebNodeDbo;

public class ServerComparator implements Comparator<WebNodeDbo> {

	@Override
	public int compare(WebNodeDbo o1, WebNodeDbo o2) {
		return o1.getWebServerName().compareTo(o2.getWebServerName());
	}

}
