package com.dw.model.basis.events;

import java.util.Date;

public abstract class Event {
	
	private String id;
	private Long event_time;
	private Integer points;
	private String type;
	private Integer tzoffset;
	
	public Date getEventTime() {
		return new Date(event_time * 1000);
	}

	public String getId() {
		return id;
	}

	public Integer getPoints() {
		return points;
	}

	public String getType() {
		return type;
	}

	public Integer getTzOffset() {
		return tzoffset;
	}

}
