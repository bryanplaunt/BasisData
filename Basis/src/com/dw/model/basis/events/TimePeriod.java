package com.dw.model.basis.events;

public class TimePeriod extends Event{
	
	private Integer activity;
	private Integer activity_count;
	private String activity_goal;
	private Integer calories;
	private Double calories_avg;
	private Integer calories_goal;
	private String day;
	private Integer days;
	private Integer habits_hit;
	private Integer habits_quota_met;
	private Integer habits_total;
	private Double resting_heartrate;
	private Integer sleep;
	private Double sleep_avg;
	private Double sleep_quality;
	private String start;
	private Integer steps;
	private Double steps_avg;
	private Integer steps_goal;
	private Integer times_awoken;
	private String timezone;

	public Integer getActivity() {
		return activity;
	}
	
	public Integer getActivity_count() {
		return activity_count;
	}
	
	public String getActivity_goal() {
		return activity_goal;
	}
	
	public Integer getCalories() {
		return calories;
	}
	
	public Double getCalories_avg() {
		return calories_avg;
	}
	
	public Integer getCalories_goal() {
		return calories_goal;
	}
	
	public String getDay() {
		return day;
	}
	
	public Integer getDays() {
		return days;
	}
	
	public Integer getHabits_hit() {
		return habits_hit;
	}
	
	public Integer getHabits_quota_met() {
		return habits_quota_met;
	}
	
	public Integer getHabits_total() {
		return habits_total;
	}
	
	public Double getResting_heartrate() {
		return resting_heartrate;
	}
	
	public Integer getSleep() {
		return sleep;
	}
	
	public Double getSleep_avg() {
		return sleep_avg;
	}
	
	public Double getSleep_quality() {
		return sleep_quality;
	}
	
	public String getStart() {
		return start;
	}
	
	public Integer getSteps() {
		return steps;
	}
	
	public Double getSteps_avg() {
		return steps_avg;
	}
	
	public Integer getSteps_goal() {
		return steps_goal;
	}
	
	public Integer getTimes_awoken() {
		return times_awoken;
	}
	
	public String getTimezone() {
		return timezone;
	}

}
