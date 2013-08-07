package com.dw;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;

import com.dw.model.basis.metrics.BodyState;
import com.dw.model.basis.metrics.Metrics;
import com.dw.model.basis.metrics.Observation;

public class BasisCSVFileWriter {

	public static final String DELIMETER = ",";

	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void render(Metrics dataset) {
		StringBuffer observationsBuffer = new StringBuffer();

		for (Observation obs : dataset.getMetrics().getObservations()) {
			observationsBuffer.append(dateFormat.format(obs.getObservationDate()) + DELIMETER + format(obs.getAirTemp()) + DELIMETER
					+ format(obs.getCalories()) + DELIMETER + format(obs.getGsr()) + DELIMETER + format(obs.getHeartrate()) + DELIMETER
					+ format(obs.getSkinTemp()) + DELIMETER + format(obs.getSteps()) + "\r\n");
		}

		StringBuffer bodyStatesBuffer = new StringBuffer();

		for (BodyState bbs : dataset.getBodystates()) {
			bodyStatesBuffer.append(dateFormat.format(bbs.getStartTime()) + DELIMETER + dateFormat.format(bbs.getEndTime()) + DELIMETER
					+ bbs.getBodystate() + "\r\n");
		}

		File observationsFile = new File("C:\\temp\\observations.txt");
		File bodyStatesFile = new File("C:\\temp\\bodystates.txt");
		try {
			FileUtils.writeStringToFile(observationsFile, observationsBuffer.toString());
			FileUtils.writeStringToFile(bodyStatesFile, bodyStatesBuffer.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static String format(Object value) {
		String returnValue = "";
		if (value != null)
			returnValue = value.toString();
		return returnValue;
	}

}
