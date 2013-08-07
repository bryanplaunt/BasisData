package com.dw;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.dw.model.basis.events.Events;
import com.dw.model.basis.events.Exercise;
import com.dw.model.basis.events.Notification;
import com.dw.model.basis.events.Sleep;
import com.dw.model.basis.events.TimePeriod;
import com.dw.model.basis.events.Timezone;
import com.dw.model.basis.metrics.Id;
import com.dw.model.basis.metrics.Metrics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BasisParser {

	public Events getInsightDataset(URL url, Id id) {
		String result = null;

		try {
			result = jsonForURL(url, id);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	    Gson gson = new Gson();
	    
	    JsonParser parser = new JsonParser();
	    JsonArray array = parser.parse(result).getAsJsonArray();

		//System.out.println(result);
	    Events basisEvents = new Events();

	    for (Iterator<JsonElement> i = array.iterator(); i.hasNext(); ) {
		    JsonObject jo = (JsonObject) i.next();
		    Set<Entry<String, JsonElement>> es = jo.entrySet();

		    //System.out.println("========");
		    //System.out.println(jo);

		    for (Entry<String, JsonElement> e : es) {
		    	if ("type".equals(e.getKey())) {
		    		if ("\"notification\"".equals(e.getValue().toString())) {
		    			basisEvents.addNotificationSummary(gson.fromJson(jo.toString(), Notification.class));
		    		} else if ("\"day\"".equals(e.getValue().toString()) || "\"week\"".equals(e.getValue().toString())) {
		    			basisEvents.addTimePeriod(gson.fromJson(jo.toString(), TimePeriod.class));
		    		} else if ("\"sleep\"".equals(e.getValue().toString())) {
		    			basisEvents.addSleepSummary(gson.fromJson(jo.toString(), Sleep.class));
		    		} else if ("\"exercise\"".equals(e.getValue().toString())) {
		    			basisEvents.addExerciseSummary(gson.fromJson(jo.toString(), Exercise.class));
		    		} else if ("\"timezone\"".equals(e.getValue().toString())) {
		    			basisEvents.addTimezoneSummary(gson.fromJson(jo.toString(), Timezone.class));
		    		} 
		    	}
		    	//System.out.println(e.getKey() + ": " + e.getValue().toString());
		    }
	    }
    	return basisEvents;

	}

	public Metrics getDataset(URL url) {
		String result = null;

		try {
			result = jsonForUrl(url);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return getDataset(result);
	}

	public Metrics getDataset(File file) {
		String result = null;

		try {

			Path path = Paths.get(file.getName());
			List<String> results = Files.readAllLines(path, StandardCharsets.UTF_8);

			StringBuffer sb = new StringBuffer();
			for (String r : results) {
				sb.append(r);
			}

			result = sb.toString();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return getDataset(result);
	}

	private Metrics getDataset(String result) {
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(result, Metrics.class);
	}

	// TODO Rename or refactor
	private String jsonForURL(URL url, Id id) throws IOException {
		HttpURLConnection urlx = (HttpURLConnection) url.openConnection();

		urlx.addRequestProperty("Cookie", "optimizelyEndUserId=oeu1372419820740r0.8522156907711178; __utma=174953330.1108579197.1373861250.1374418844.1374458989.3; __utmz=174953330.1373861250.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); optimizelySegments=%7B%7D; optimizelyBuckets=%7B%7D; __utma=268343826.1036922636.1372419821.1372814507.1375050001.6; __utmz=268343826.1372808312.4.2.utmcsr=support.mybasis.com|utmccn=(referral)|utmcmd=referral|utmcct=/forums/21712226-Product-Feedback; scope=login; access_token=835b56d838e87de2249f7756e4b78f00; refresh_token=992ccaf424560965dae950ae58731159");
		urlx.addRequestProperty("X-Basis-Authorization", "OAuth " + id.getOAuth());
		
		return jsonForUrl(urlx);
	}

	private String jsonForUrl(URLConnection urlx) throws IOException {
		return readBuffer(new BufferedReader(new InputStreamReader(urlx.getInputStream())));
	}
	
	private String jsonForUrl(URL url) throws IOException {
		return readBuffer(new BufferedReader(new InputStreamReader(url.openStream())));
	}
	
	private String readBuffer(BufferedReader in) throws IOException {
		StringBuffer sb = new StringBuffer();
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			sb.append(inputLine);
		in.close();
		return sb.toString();
	}

}
