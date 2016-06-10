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
    	 //response.getWriter().write("Hello numbers:"+la);
    	 if(la!=null){
    	 String Path = "http://www.twcnews.com/services/weather/sunmoon."+la+".json";
    	 //response.getWriter().write("Path/n"+Path);
    	// System.out.println("Path"+Path);
    	 
    	 
    	 URL ll = new URL(Path);
    	 
    	 
    	 log.info("url: " +ll);
    	 
    	 
         //response.getWriter().write("url:"+ll);
         
         
         HttpURLConnection connection = null;
         connection = (HttpURLConnection) ll.openConnection();
         
         
         
         log.info("Connection: " + connection);
         //response.getWriter().write("Connection: " + connection);
         //int responseCode = -1;
         //responseCode = connection.getResponseCode();
         //response.getWriter().write("responseCode: " + responseCode );
         BufferedReader in;
         in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
         log.info("reader: " + in);
         //response.getWriter().write("reader: " + in );
         //String result = "";
         //result = reader.readLine();
        // log.info("result: " + result);
         //response.getWriter().write("result: " + result );
        
         //response.setContentType("application/json");
         //response.setCharacterEncoding("UTF-8");
         //response.getWriter().write(result);
         String inputLine = "";
 		 //StringBuffer response = new StringBuffer();
 		while ((inputLine = in.readLine()) != null) {
			//response.append(inputLine);
		}
		//in.close();
 		response.getWriter().write(inputline);
         }
    	}
    	catch(Exception e){
    		
    	} 

    	}              
}