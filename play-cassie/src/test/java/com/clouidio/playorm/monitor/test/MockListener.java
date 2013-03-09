package com.clouidio.monitor.test;

import com.clouidio.monitor.api.MonitorListener;
import com.clouidio.monitor.api.PlayCassieMonitor;

public class MockListener implements MonitorListener {

	private PlayCassieMonitor lastFired;

	@Override
	public void monitorFired(PlayCassieMonitor m) {
		this.lastFired = m;
	}

	public PlayCassieMonitor getLastFiredMonitor() {
		PlayCassieMonitor temp = lastFired;
		lastFired = null;
		return temp;
	}

}
