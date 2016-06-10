package com.mycompany.myproject.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.TidyJSONWriter;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
@SuppressWarnings("serial")
@SlingServlet(
   generateService = true,
   generateComponent = true,
  metatype = true,
  methods = { "GET" },
  paths = { "/bin/TestServlets" }
)
     public class testServlets extends SlingSafeMethodsServlet {
     private Logger log = LoggerFactory.getLogger(testServlets.class);
     ResourceResolver resourceResolver;

     protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException 
{ 
   try{

       String[] selectors = request.getRequestPathInfo().getSelectors();
       String firstName = selectors[0];
       log.info("Date Of firstName *********"+firstName);
       String lastName = selectors[1];
       log.info("Date Of lastName *********"+lastName);
       //log.info(" In test Servlet  ----- " +firstName  );
       response.getWriter().write("Hello World First Name :"+firstName+"  Last Name :"+lastName);	
      }
   catch(Exception e){
      log.error("Error parsing slection"+ e);
           }
   finally{
    response.getWriter().flush();
    response.getWriter().close();
}
}
}