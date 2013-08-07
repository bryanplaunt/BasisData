package com.dw.model.basis.metrics;

import java.util.ArrayList;
import java.util.List;

public class Measurements {

	private Observations air_temp;
	private Observations calories;
	private Observations gsr;
	private Observations heartrate;
	private Observations skin_temp;
	private Observations steps;

	private Long starttime;
	private Long endtime;

	private boolean isInitialized = false;

	private static final String TIMES_NOT_INITIALIZED_MESSAGE = "Start and end times not set";

	public Observations getAirTemp() {
		return air_temp;
	}

	public Observations getCalories() {
		return calories;
	}

	public long getEndtime() {
		return endtime;
	}

	public Observations getGsr() {
		return gsr;
	}

	public Observations getHeartrate() {
		return heartrate;
	}

	public Observation getObservation(int index) throws IllegalStateException {
		if (!isInitialized)
			throw new IllegalStateException(TIMES_NOT_INITIALIZED_MESSAGE);
	
		Integer heartrateAsInteger = null;
	
		if (heartrate.getValues().get(index) != null)
			heartrateAsInteger = new Integer(Double.valueOf(heartrate.getValues().get(index)).intValue());
	
		Integer stepsAsInteger = null;
	
		if (steps.getValues().get(index) != null)
			stepsAsInteger = new Integer(Double.valueOf(steps.getValues().get(index)).intValue());
	
		return Observation.asObservation(starttime + (index * 60), air_temp.getValues().get(index), calories.getValues().get(index), gsr
				.getValues().get(index), heartrateAsInteger, skin_temp.getValues().get(index), stepsAsInteger);
	}

	public List<Observation> getObservations() {
		if (!isInitialized)
			throw new IllegalStateException(TIMES_NOT_INITIALIZED_MESSAGE);
	
		List<Observation> observations = new ArrayList<Observation>();
		for (int i = 0; i < size(); i++) {
			observations.add(getObservation(i));
		}
		return observations;
	
	}

	public Observations getSkinTemp() {
		return skin_temp;
	}

	public Observations getSteps() {
		return steps;
	}

	public int size() {
		// Assume all are the same size
		return air_temp.getValues().size();
	}

	public void setTimes(long starttime, long endtime) {
		this.starttime = starttime;
		this.endtime = endtime;
		isInitialized = true;
	}

}
