package com.dw.model.basis.metrics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class Id {
	
	private static Id instance;
	private static Properties props;
	
	public static final String BASIS_ID = "basis_id";
	public static final String OAUTH = "volatile_oauth_token";
	
	private Id() {
		// No external instantiation
		props = new Properties();
	}
	
	public String getId() {
		return props.getProperty(BASIS_ID);
	}
	
	public static Id getInstance(File file) {
		instance = new Id();
		
		try {
			props.load(new FileInputStream(file));
			// TODO Handle positions as constants
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return instance;
	}
	
	public String getOAuth() {
		return props.getProperty(OAUTH);
	}

}
