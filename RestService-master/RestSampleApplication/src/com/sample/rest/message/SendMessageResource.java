package com.sample.rest.message;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.json.simple.JSONObject;


//@Provider annotation is not needed in the Service Class
@Path(value = "/message")
public class SendMessageResource {
	
	private static String message;

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path(value = "getText")
	public String sendATextMessage (@QueryParam("name") String name) {
		System.out.println("Inside getText service");
		message = "This is a sample text message " + name;
		return message;
	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path(value = "postText")
	public String sendAPostMessage (String name) {
		System.out.println("Inside postText service");
		message = "This is a post text message" + name;
		return message;
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "getJSON")
	public String sendAJSONMessage (@QueryParam("name") String name) {
		System.out.println("Inside getJSON service");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", "This is a sample JSON Message");
		jsonObject.put("name",name);
		return jsonObject.toJSONString();
	}

	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.TEXT_HTML)
	@Path(value = "getHtml")
	public String sendAHTMLMessage (@QueryParam("name") String name) {
		System.out.println("Inside getHtml service");
		message = "<html><body>This is a sample HTML Document " + name + "</body></html>";
		return message;
	}
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	@Path(value = "postFormData")
	public String sendAFormDataMessage (@FormDataParam("uploadFile") String s) {
		System.out.println("Inside sendAFormDataMessage service");
		message = s;
		return message;
	}
}