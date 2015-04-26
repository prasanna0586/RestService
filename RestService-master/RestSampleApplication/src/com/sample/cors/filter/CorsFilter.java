package com.sample.cors.filter;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		System.out.println("CorsFilter entry");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		List<String> reqHead = requestContext.getHeaders().get("Access-Control-Request-Headers");
		if(reqHead != null){
			responseContext.getHeaders().put("Access-Control-Allow-Headers", new ArrayList<Object>(reqHead));
		}
		System.out.println("CorsFilter exit");
	}
}