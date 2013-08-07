package com.dw.model.basis.metrics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Metrics {

	private ArrayList<ArrayList<String>> bodystates;
	private ArrayList<BodyState> processedBodystates;
	private ArrayList<TimeZone> timezone_history;

	private Measurements metrics;

	private long starttime;
	private long endtime;
	private long interval;

	private static final int START_TIME_POSITION = 0;
	private static final int END_TIME_POSITION = 1;
	private static final int BODYSTATE_POSITION = 2;
	
	public List<BodyState> getBodystates() {
		if (processedBodystates == null) {
			processedBodystates = new ArrayList<BodyState>();
			for (List<String> bodystateList : bodystates) {
				BodyState bbs = new BodyState(
						Long.valueOf(bodystateList.get(START_TIME_POSITION)),
						Long.valueOf(bodystateList.get(END_TIME_POSITION)),
						bodystateList.get(BODYSTATE_POSITION));
				processedBodystates.add(bbs);
			}
		}
		return processedBodystates;
	}

	public Date getEndDate() {
		return new Date(endtime * 1000);
	}

	public long getEndTime() {
		return endtime;
	}

	public long getInterval() {
		return interval;
	}

	public Measurements getMetrics() {
		metrics.setTimes(starttime, endtime);
		return metrics;
	}

	public Date getStartDate() {
		return new Date(starttime * 1000);
	}

	public long getStartTime() {
		return starttime;
	}

	public ArrayList<TimeZone> getTimezoneHistory() {
		return timezone_history;
	}

	@Override
	public String toString() {
		return "Start Date: " + getStartDate() + "\r\nEnd Date: "
				+ getEndDate() + "\r\nInterval: " + interval
				+ "\r\nObservations: " + metrics.size()
				+ "\r\nTimezone entries: " + timezone_history.size()
				+ "\r\nBodystate entries: " + bodystates.size();
	}

}
