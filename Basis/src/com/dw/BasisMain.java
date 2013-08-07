package com.dw;

import java.io.File;

import com.dw.model.basis.events.Events;
import com.dw.model.basis.metrics.Id;
import com.dw.model.basis.metrics.Metrics;

public class BasisMain {

	private static final String MIN_START_DATE = "2013-06-29";

	// TODO Be careful with the ***current date***. Unless you use offsets, the
	// results will pick up null
	// values from the last sync through the end of the day

	public static void main(String[] args) {

		BasisProperties bp = BasisProperties.getInstance();

		// Get Id
		Id id = Id.getInstance(new File(bp.getProperty(BasisProperties.KEY_FILE_PATH)));

		BasisParser parser = new BasisParser();
		BasisAccessDbImpl db = new BasisAccessDbImpl();

		if (Boolean.valueOf(bp.getProperty(BasisProperties.GET_METRICS))) {
			Metrics metrics = parser.getDataset(BasisResourceLocators.getDetailsLocator(id, bp.getProperty(BasisProperties.METRICS_START_DATE),
					bp.getProperty(BasisProperties.METRICS_END_DATE), bp.getProperty(BasisProperties.METRICS_START_OFFSET),
					bp.getProperty(BasisProperties.METRICS_END_OFFSET), bp.getProperty(BasisProperties.METRICS_INTERVAL),
					bp.getProperty(BasisProperties.METRICS_UNITS)));
			db.writeMetrics(metrics);
		}

		if (Boolean.valueOf(bp.getProperty(BasisProperties.GET_METRICS))) {
			Events events = parser.getInsightDataset(BasisResourceLocators.getInsightLocator(bp.getProperty(BasisProperties.EVENTS_START_DATE)), id);
			db.writeEvents(events);
		}

		if (db != null) {
			if (!db.isClosed()) {
				db.close();
			}
		}
		
		System.out.println("Done");
		// BasisCSVFileWriter.render(metrics);
	}
}
