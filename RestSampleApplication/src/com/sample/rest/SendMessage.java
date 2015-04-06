package com.sample.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.json.simple.JSONObject;

@Provider
@Path(value = "/message")
public class SendMessage extends ResourceConfig {

	private static String message; 
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String sendATextMessage () {
		message = "This is a sample text message";
		return message;
	}
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String sendAJSONMessage () {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", "This is a sample JSON Message");
		return jsonObject.toJSONString();
	}
	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.TEXT_HTML)
	public String sendAHTMLMessage () {
		message = "<html><body>This is a sample HTML Document </body></html>";
		return message;
	}
}