package com.sample.rest.arithmetic;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;

@Provider
@Path(value = "/arithmetic")
public class Arithmetic extends ResourceConfig {

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	
	public Float sum (@QueryParam("listOfNumbers") List<Float> listOfNumbers) {
		Float result;
		if(listOfNumbers != null) {
			result = new Float(0.0);
			System.out.println("listOfNumbers " + listOfNumbers);
			for (Float number : listOfNumbers) {
				result = result + number;
				System.out.println("result " + result);
			}
		} else {
			throw new NullPointerException("The list of numbers is null");
		}
		return result;
	}
}
