package com.dw.model.basis.events;

import java.util.Date;

public class Exercise extends Event {

	private Double calories;
	private Double calories_avg;
	private String day;
	private Integer duration;
	private Long end_time;
	private Long start;
	private Long start_time;
	private Integer steps;

	public Double getCalories() {
		return calories;
	}

	public Double getCaloriesAvg() {
		return calories_avg;
	}

	public String getDay() {
		return day;
	}

	public Integer getDuration() {
		return duration;
	}

	public Date getEndTime() {
		return new Date(end_time * 1000);
	}

	public Date getStart() {
		Date d = null;
		if (start != null)
			d = new Date(start * 1000);
		return d;
	}

	public Date getStartTime() {
		return new Date(start_time * 1000);
	}

	public Integer getSteps() {
		return steps;
	}

}
