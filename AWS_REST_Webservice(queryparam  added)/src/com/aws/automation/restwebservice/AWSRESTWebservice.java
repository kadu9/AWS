package com.aws.automation.restwebservice;
import com.aws.automation.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/automateaws")
public class AWSRESTWebservice {

	@Path("/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getString(@QueryParam("name") String name, @QueryParam("email") String email) throws Exception  {

		System.out.println("emmail:"+email);
	//	AWSAutomationDriverClass automationDriverClass = new AWSAutomationDriverClass(email);
	//	automationDriverClass.automateAWS();
		return Response.ok("hi from "+name+" Webservice!!..").build();
				
		
	}

	
}

