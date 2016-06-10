package com.mycompany.myproject.servlets;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import javax.jcr.Node;
import javax.jcr.Session;

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
@SuppressWarnings("serial")
@SlingServlet(
  metatype = true,
  methods = { "POST","GET"},
  paths = { "/bin/submitform" }
)
     public class formSubmit extends SlingAllMethodsServlet {
     private Logger log = LoggerFactory.getLogger(formSubmit.class);
     //ResourceResolver resourceResolver;
     
     
      //String resourcePath = "/content/usergenerated/content";
     
  // req is the SlingHttpServletRequest
  
     //Resource myResource = resourceResolver.getResource(resourcePath);
     
     

     //Resource myResource = resourceResolver.getResource("/content/usergenerated/content");
    //Node node = resource.adaptTo(Node.class);
     
     //+String query = "/jcr:root/etc/workflow/instances///jcr:root/etc/replication/agents.author//*[@transportUri]"; // 1
     //Iterator<Resource> myResources = resourceResolver.findResources(query, "xpath"); 
     
     
     
     
     @Override
     protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException{ 
    	try{
    	
    	 String firstName = request.getParameter("firstname");
    	 log.info("First Name *********"+ firstName);
    	 
    	 String LastName = request.getParameter("lastname");
    	 log.info("Last Name *********"+ LastName);
    	 
    	/* String Email = request.getParameter("Email");
    	 log.info("Email *********"+ Email);
    	 
    	 String PhoneNumber = request.getParameter("Phone number");
    	 log.info("PhoneNumber *********"+ PhoneNumber);
    	 
    	 
    	 String DateOfBirth = request.getParameter("DOB");
    	 log.info("Date Of Birth *********"+ DateOfBirth);
    	 
    	 String Address = request.getParameter("address");
    	 log.info("Address *********"+ Address);
    	 
    	 
    	 String Gender = request.getParameter("gender");
    	 log.info("Gender *********"+ Gender);
    	 
    	 String Nationality = request.getParameter("nationality");
    	 log.info("Nationality *********"+ Nationality);*/
    	 
    	 String pathto ="/content/usergenerated/content";
    	 Resource  myResource = request.getResourceResolver().getResource(pathto);
    	 Node node = myResource.adaptTo(Node.class);
    	
    	 node.addNode(request.getParameter("firstname"));
    	 node.save();
    	 if (node.hasNode(request.getParameter("firstname"))){
    		Node node1= node.getNode(request.getParameter("firstname"));
    		 node1.setProperty("lastName", LastName);
    		 //node1.setProperty("email", Email);
    		 //node1.setProperty("dateOfBirth", DateOfBirth);
    		 //node1.setProperty("address", Address);
    		 //node1.setProperty("gender", Gender);
    		 //node1.setProperty("nationality", Nationality);
    		node1.save(); 
    	 }
    	}
    	catch(Exception e){
    		log.error("Failed to create node"+e);
    	} 

    	}              
}