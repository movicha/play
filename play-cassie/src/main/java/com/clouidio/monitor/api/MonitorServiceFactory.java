package com.clouidio.monitor.api;

import java.util.Map;

public abstract class MonitorServiceFactory {

	private static final String OUR_IMPL = "com.clouidio.monitor.bindings.MonitorServiceFactoryImpl";
	
	public static final String SCAN_RATE_MILLIS = "com.clouidio.monitor.scanrate";
	public static final String HOST_UNIQUE_NAME = "com.clouidio.monitor.host";	
	
	private volatile static MonitorService singleton;
	
	public static MonitorService getSingleton(Map<String, Object> properties) {
		//double checked locking is ONLY ok if you use the keyword volatile in java
		synchronized(MonitorServiceFactory.class) {
			if(singleton == null)
				singleton = create(properties);
		}
		return singleton;
	}
	
	public synchronized static MonitorService create(Map<String, Object> properties) {
		MonitorServiceFactory newInstance = createInstance(OUR_IMPL);
		return newInstance.createService(properties);
	}

	public static final String NOSQL_MGR_FACTORY = "com.clouidio.monitor.factory";

	protected abstract MonitorService createService(Map<String, Object> properties);

	private static MonitorServiceFactory createInstance(String impl) {
		try {
			Class<?> clazz = Class.forName(impl);
			MonitorServiceFactory newInstance = (MonitorServiceFactory) clazz.newInstance();
			return newInstance;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

}
