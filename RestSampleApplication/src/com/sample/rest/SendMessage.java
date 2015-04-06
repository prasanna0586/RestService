package com.sample.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;
import org.glassfish.jersey.server.ResourceConfig;
import org.json.simple.JSONObject;

@Path(value = "/message")
public class SendMessage extends ResourceConfig {
	
	public SendMessage () {
		packages("com.sample.rest.SendMessage");
		//register(com.sample.cors.filter.CorsFilter.class);
	}

	private static String message; 
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sendATextMessage (@Context HttpHeaders header, @Context Response response) {
		message = "This is a sample text message";
		return message;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sendAJSONMessage () {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", "This is a sample JSON Message");
		return jsonObject.toJSONString();
	}
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sendAHTMLMessage () {
		message = "<html><body>This is a sample HTML Document </body></html>";
		return message;
	}
}