package com.mycompany.myproject.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import javax.jcr.Node;
import javax.jcr.Session;
import java.net.URL;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.Resource;

import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.TidyJSONWriter;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import javax.net.ssl.HttpsURLConnection;


@SuppressWarnings("serial")
@SlingServlet(
  metatype = true,
  methods = { "GET"},
  paths = { "/bin/sun" }
)

     public class sun extends SlingAllMethodsServlet {
     private Logger log = LoggerFactory.getLogger(sun.class);
     @Override
     protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException{ 
    	 
     
    	try{
    	
    	 String la = request.getParameter("nums");
    	 log.info("number is*********"+ la);
		  if(la!=null){
    	 String Path = "http://www.twcnews.com/services/weather/current."+la+".json";
		 URL url = new URL(Path);
		 log.info("url: " +url);
		 HttpURLConnection connection = null;
         connection = (HttpURLConnection) url.openConnection();
		 log.info("Connection: " + connection);
		 BufferedReader reader;
         reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		 log.info("reader: " + reader);
		 String result = "";
		 //StringBuffer response = new StringBuffer();
		 while ((result = reader.readLine()) != null) {
			 response.getWriter().write(result);
		    }
		  } 
		}
        catch(Exception e){
    		
    	} 

    	}              
}
		