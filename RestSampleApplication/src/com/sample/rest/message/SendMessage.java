package com.sample.rest.message;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.json.simple.JSONObject;


//@Provider annotation is not needed in the Service Class
@Path(value = "/message")
public class SendMessage extends ResourceConfig {

	private static String message;

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String sendATextMessage (@QueryParam("name") String name) {
		message = "This is a sample text message " + name;
		System.out.println("Inside sendATextMessage service");
		return message;
	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String sendAPostMessage (String name) {
		message = "This is a post text message" + name;
		return message;
	}

	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String sendAPutMessage (@QueryParam("name") String name) {
		message = "This is a put text message " + name;
		return message;
	}

	@DELETE
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String sendADeleteMessage (@QueryParam("name") String name) {
		message = "This is a delete text message " + name;
		return message;
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String sendAJSONMessage (@QueryParam("name") String name) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", "This is a sample JSON Message");
		jsonObject.put("name",name);
		return jsonObject.toJSONString();
	}

	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.TEXT_HTML)
	public String sendAHTMLMessage (@QueryParam("name") String name) {
		message = "<html><body>This is a sample HTML Document " + name + "</body></html>";
		return message;
	}
}