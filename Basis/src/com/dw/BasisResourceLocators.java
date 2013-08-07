package com.dw;

import java.net.MalformedURLException;
import java.net.URL;

import com.dw.model.basis.metrics.Id;

public class BasisResourceLocators {

	// One hour offset
	// final static int START_OFFSET = 41400;
	// final static int END_OFFSET = START_OFFSET * -1;

	// Dates should be of YYYY-MM-DD format
	static URL getDetailsLocator(Id id, String startDate, String endDate, String startOffset, String endOffset, String interval, String units) {
		URL url = null;
		try {
			url = new URL("https://app.mybasis.com/api/v1/chart/" + id.getId() + ".json?" + "summary=true" + "&interval=" + interval + "&units="
					+ units + "&start_date=" + startDate + "&end_date=" + endDate + "&start_offset=" + startOffset + "&end_offset=" + endOffset
					+ "&heartrate=true" + "&steps=true" + "&calories=true" + "&gsr=true" + "&skin_temp=true" + "&air_temp=true" + "&bodystates=true");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}

	// Date should be of YYYY-MM-DD format
	static URL getInsightLocator(String date) {
		URL url = null;
		try {
			url = new URL("https://app.mybasis.com/api/v1/feed/me?week=" + date);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}

}
