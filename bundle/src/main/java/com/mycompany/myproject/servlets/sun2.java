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
  paths = { "/bin/hari" }
)

     public class sun2 extends SlingAllMethodsServlet {
     private Logger log = LoggerFactory.getLogger(sun2.class);
     @Override
     protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException{ 
    	try{
    	
    	 String la = request.getParameter("nums");
    	 log.info("number is*********"+ la);
    	 response.getWriter().write("Hello numbers:"+la);
    	 
 	}
 	catch(Exception e){
 		
 	} 

 	}              
}