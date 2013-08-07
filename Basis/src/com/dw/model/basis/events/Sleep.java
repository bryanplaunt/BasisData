package com.dw.model.basis.events;

import java.util.Date;


public class Sleep extends Event {

	private Double calories;
	private String day;
	private Integer duration;
	private Integer duration_awoken;
	private Long end_time;
	private Integer heart_rate;
	private Double quality;
	private Long start_time;
	private Integer times_awoken;
	
	public Double getCalories() {
		return calories;
	}
	
	public String getDay() {
		return day;
	}
	
	public Integer getDuration() {
		return duration;
	}
	
	public Integer getDurationAwoken() {
		return duration_awoken;
	}
	
	public Date getEndTime() {
		return new Date(end_time * 1000);
	}
	
	public Integer getHeartRate() {
		return heart_rate;
	}
	
	public Double getQuality() {
		return quality;
	}

	public Date getStartTime() {
		return new Date(start_time * 1000);
	}
	
	public Integer getTimesAwoken() {
		return times_awoken;
	}
	
}
