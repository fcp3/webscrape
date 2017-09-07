package com.fcp3.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
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
	
    public static void main( String[] args ) throws Exception
    {
        
        try {
        	Document doc = Jsoup.connect("http://mobile.njit.edu/parking/data.php").get();
        	
        	System.out.println(doc.select("body").text());
        	String text = doc.select("body").text();
        	
        	for(Element e: doc.select("div.list-group-item")) {
        		System.out.println(e.html());
        		System.out.println(e.select("div.row div").html());
        	}
        	JSONObject json = new JSONObject(text);
        	System.out.println(json.names().toString());
        	JSONObject sciTechGarage = json.getJSONObject("decks").getJSONObject("0");
        	JSONObject parkingDeck = json.getJSONObject("decks").getJSONObject("1");
        	System.out.println(sciTechGarage.toString());
        	System.out.println(parkingDeck.toString());
        	
        	//Science and Tech Garage
        	String name1 = sciTechGarage.getString("Name");
        	String available1 = sciTechGarage.getString("Available");
        	System.out.println(name1 + " : " + available1);
        	
        	
        		
        } catch (IOException e) {
        	Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, "ex");
        }
    	
    	//String json = readURL("http://http://mobile.njit.edu/parking/data.php");

    	
    }
    
    
}
