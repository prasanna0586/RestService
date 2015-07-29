package com.sample.message.dynamicbinding;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

import com.sample.message.filter.MessageFilter;
import com.sample.rest.message.SendMessageResource;
@PreMatching
public class MessageDynamicBinding implements DynamicFeature {

	@Override
	public void configure(ResourceInfo resourceInfo, FeatureContext featureContext) {
		System.out.println("MessageDynamicBinding entry");
		if (SendMessageResource.class.equals(resourceInfo.getResourceClass()) 
				&& resourceInfo.getResourceMethod().getName().contains("AHTMLMessage")) {
			System.out.println("Inside DynamicBinding if condition");
			featureContext.register(MessageFilter.class);
		}
		System.out.println("MessageDynamicBinding exit");
	}
}