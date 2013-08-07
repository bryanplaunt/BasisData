package com.dw;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.dw.model.basis.metrics.Id;

public class BasisProperties {

	public static final String BASIS_PROPERTIES_FILE_NAME = "basis.properties";
	
	public static final String KEY_FILE_PATH = "basis_key_file";

	public static final String GET_METRICS = "get_metrics";
	public static final String METRICS_END_DATE = "metrics_end_date";
	public static final String METRICS_END_OFFSET = "metrics_end_offset";
	public static final String METRICS_INTERVAL = "metrics_interval";
	public static final String METRICS_START_DATE = "metrics_start_date";
	public static final String METRICS_START_OFFSET = "metrics_start_offset";
	public static final String METRICS_UNITS = "metrics_units";
	
	public static final String GET_EVENTS = "get_events";	
	public static final String EVENTS_START_DATE = "events_start_date";
	
	public static final String DB_PATH = "db_file";
	
	private static BasisProperties bp;
	
	private static Properties prop = null;

	private BasisProperties() {
		// Non directly instantiable
	}
	
	public static BasisProperties getInstance() {
		if (prop == null) {
			bp = new BasisProperties();
			prop = new Properties();
			loadProperties();
		}
		return bp;
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}

	static void loadProperties() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader.getResourceAsStream(BASIS_PROPERTIES_FILE_NAME);
		try {
			prop.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
