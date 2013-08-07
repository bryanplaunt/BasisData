package com.dw.model.basis.metrics;

import java.util.ArrayList;

public class Observations {

	private double avg;
	private double max;
	private double min;
	private double stdev;
	private double sum;

	private ObservationsSummary summary;
	
	private ArrayList<Double> values;

	// TODO Build more appropriate impl 
	@Override
	public String toString() {
		return avg + ", " + min;
	}

	public double getAvg() {
		return avg;
	}

	public double getMax() {
		return max;
	}

	public double getMin() {
		return min;
	}

	public double getStdev() {
		return stdev;
	}

	public double getSum() {
		return sum;
	}
	
	public ObservationsSummary getSummary() {
		return summary;
	}

	public ArrayList<Double> getValues() {
		return values;
	}

}
