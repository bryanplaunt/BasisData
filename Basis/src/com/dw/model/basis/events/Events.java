package com.dw.model.basis.events;

import java.util.ArrayList;
import java.util.List;

public class Events {

	private List<TimePeriod> timePeriodEvents;
	private List<Sleep> sleepEvents;
	private List<Notification> notificationEvents;
	private List<Exercise> exerciseEvents;
	private List<Timezone> timezoneEvents;
	
	public Events() {
		timePeriodEvents = new ArrayList<TimePeriod>();
		exerciseEvents = new ArrayList<Exercise>();
		notificationEvents = new ArrayList<Notification>();
		sleepEvents = new ArrayList<Sleep>();
		timezoneEvents = new ArrayList<Timezone>();
	}

	public void addTimePeriod(TimePeriod day) {
		timePeriodEvents.add(day);
	}
	
	public void addExerciseSummary(Exercise exerciseEvent) {
		exerciseEvents.add(exerciseEvent);
	}

	public void addNotificationSummary(Notification notificationEvent) {
		notificationEvents.add(notificationEvent);
	}

	public void addSleepSummary(Sleep sleepEvent) {
		sleepEvents.add(sleepEvent);
	}
	
	public void addTimezoneSummary(Timezone timezoneEvent) {
		timezoneEvents.add(timezoneEvent);
	}

	public List<TimePeriod> getTimePeriodEvents() {
		return timePeriodEvents;
	}

	public List<Sleep> getSleepEvents() {
		return sleepEvents;
	}

	public List<Notification> getNotificationEvents() {
		return notificationEvents;
	}

	public List<Exercise> getExerciseEvents() {
		return exerciseEvents;
	}

	public List<Timezone> getTimezoneEvents() {
		return timezoneEvents;
	}

}
