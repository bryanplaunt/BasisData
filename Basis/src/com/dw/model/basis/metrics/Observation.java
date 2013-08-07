package com.dw.model.basis.metrics;

import java.util.Date;

public class Observation {

	private long time;
	private Double air_temp;
	private Double calories;
	private Double gsr;
	private Integer heartrate;
	private Double skin_temp;
	private Integer steps;

	private Observation() {
		// No direct instantiation
	}

	static Observation asObservation(long timeAsSeconds, Double air_temp, Double calories, Double gsr, Integer heartrate, Double skin_temp,
			Integer steps) {

		Observation obs = new Observation();

		obs.time = timeAsSeconds;
		obs.air_temp = air_temp;
		obs.calories = calories;
		obs.gsr = gsr;
		obs.heartrate = heartrate;
		obs.skin_temp = skin_temp;
		obs.steps = steps;

		return obs;
	}

	public Double getAirTemp() {
		return air_temp;
	}

	public Double getCalories() {
		return calories;
	}

	public Double getGsr() {
		return gsr;
	}

	public Integer getHeartrate() {
		return heartrate;
	}

	public Date getObservationDate() {
		return new Date(time * 1000);
	}

	public Double getSkinTemp() {
		return skin_temp;
	}

	public Integer getSteps() {
		return steps;
	}

	@Override
	public String toString() {
		return "Observation Date: " + getObservationDate() + "\r\nAir temp: " + air_temp + "\r\nCalories: " + calories + "\r\nGSR: " + gsr
				+ "\r\nHeartrate: " + heartrate + "\r\nSkin temp: " + skin_temp + "\r\nSteps: " + steps;
	}
}
