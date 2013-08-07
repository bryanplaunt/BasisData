package com.dw.model.basis.metrics;

import java.util.Date;

public class BodyState {

	private long endtime;
	private long starttime;
	private String bodystate;

	@SuppressWarnings("unused")
	private BodyState() {
	}

	BodyState(long starttime, long endtime, String bodystate) {
		this.starttime = starttime;
		this.endtime = endtime;
		this.bodystate = bodystate;
	}

	public String getBodystate() {
		return bodystate;
	}

	public Date getEndTime() {
		return new Date(endtime * 1000);
	}

	public Date getStartTime() {
		return new Date(starttime * 1000);
	}

	@Override
	public String toString() {
		return bodystate + " from " + getStartTime() + " to " + getEndTime();
	}

}
