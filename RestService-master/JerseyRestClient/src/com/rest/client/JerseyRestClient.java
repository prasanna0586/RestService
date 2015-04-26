package com.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JerseyRestClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		String[] string = new String[1];
		string[0] = "Sahana";
		WebTarget webTarget = client.target("http://127.0.0.1:8080/RestSampleApplication/rest");
		WebTarget messageWebTarget = webTarget.path("message");
		WebTarget postFormDataTarget = messageWebTarget.path("getText");
		WebTarget messageWebTargetWithQueryParam = postFormDataTarget.queryParam("name", string);
		Invocation.Builder invocationBuilder = messageWebTargetWithQueryParam.request();
		invocationBuilder.header("Authorization","Basic d2Vic2VydmljZXVzZXI6Q2hlbHNlYWZjQDA1ODY=");
		Response response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
}
