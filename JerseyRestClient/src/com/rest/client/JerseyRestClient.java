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
		WebTarget webTarget = client.target("http://192.168.7.53:81/RestSampleApplication/rest/message");
		webTarget.queryParam("name", "Lakshmi");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.TEXT_PLAIN);
		invocationBuilder.header("Authorization","Basic d2Vic2VydmljZXVzZXI6Q2hlbHNlYWZjQDA1ODY=");
		Response response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
}
