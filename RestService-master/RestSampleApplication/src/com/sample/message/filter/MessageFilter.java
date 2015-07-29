package com.sample.message.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;

import com.thoughtworks.xstream.XStream;
@PreMatching
public class MessageFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		System.out.println("MessageFilter entry");
		//responseContext.setEntity("This is a message modified by filter");
		System.out.println(new XStream().toXML(requestContext.getPropertyNames()));
		System.out.println("MessageFilter exit");
		
	}

}
