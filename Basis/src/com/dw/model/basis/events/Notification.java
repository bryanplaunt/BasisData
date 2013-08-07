package com.dw.model.basis.events;

import java.util.Date;

public class Notification extends Event {

	private String date;
	private String habit_display;
	private String habit_name;
	private Integer quota;
	private Long start;

	public String getDate() {
		return date;
	}

	public String getHabitDisplay() {
		return habit_display;
	}

	public String getHabitName() {
		return habit_name;
	}

	public Integer getQuota() {
		return quota;
	}

	public Date getStart() {
		Date d = null;
		if (start != null)
			d = new Date(start * 1000);
		return d;
	}

}
