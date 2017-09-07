package com.fcp3.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.json.*;

/**
 * Hello world!
 *
 */



public class App 
{
	
	String URL = "http://mobile.njit.edu/parking/data.php";
	Document doc;
	private static JSONObject json;
	
	private static JSONObject getJSONObject(JSONObject json, String obj) {
		JSONObject jsonObj = null;
		try {
			jsonObj = json.getJSONObject("decks").getJSONObject(obj);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObj;
	}
	
    public static void main( String[] args ) throws Exception
    {
        
        try {
        	Document doc = Jsoup.connect("http://mobile.njit.edu/parking/data.php").get();
        	
        	System.out.println(doc.select("body").text());
        	String text = doc.select("body").text();
        	
        	json = new JSONObject(text);
        	System.out.println(json.toString());
        	
        	JSONObject sciTechGarage = getJSONObject(json, "0");
        	JSONObject parkingDeck = getJSONObject(json, "1");
        	
        	//Science and Tech Garage
        	String name1 = sciTechGarage.getString("Name");
        	String available1 = sciTechGarage.getString("Available");
        	
        	//Parking Deck
        	String name2 = parkingDeck.getString("Name");
        	String available2 = parkingDeck.getString("Available");
        	
        	
        	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        	
        	String out1 = timeStamp + " - " + name1 + " : " + available1;
        	String out2 = timeStamp + " - " + name2 + " : " + available2;
        	
        	//Files.write("output.txt", (out1 + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        	
        		
        } catch (IOException e) {
        	Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, "ex");
        }
    	
    	//String json = readURL("http://http://mobile.njit.edu/parking/data.php");

    	
    }
    
    
}
