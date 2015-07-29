package com.sample.message.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;

import com.thoughtworks.xstream.XStream;
@PreMatching
//If the prematching annotation is not used, 
//the method would be matched based on the URL and it would be invoked/executed
//Prematching when used will force the container to execute the filter first and the method is matched based on URL later
//When prematching is used dynamic binding may not have any effect and the filter is applied globally for all resources
public class MessageFilter implements ContainerRequestFilter  {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("MessageFilter entry");
		//responseContext.setEntity("This is a message modified by filter");
		System.out.println(new XStream().toXML(requestContext.getPropertyNames()));
		System.out.println("MessageFilter exit");
		
	}

}
