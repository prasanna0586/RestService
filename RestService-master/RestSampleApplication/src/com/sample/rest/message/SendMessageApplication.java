package com.sample.rest.message;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.sample.cors.filter.CorsFilter;
import com.sample.message.dynamicbinding.MessageDynamicBinding;

@ApplicationPath("/")
public class SendMessageApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(SendMessageResource.class);
        classes.add(CorsFilter.class);
        classes.add(MessageDynamicBinding.class);
        classes.add(MultiPartFeature.class);
        return classes;
    }
}