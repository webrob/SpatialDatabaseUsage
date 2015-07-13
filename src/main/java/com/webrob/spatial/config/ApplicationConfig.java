package com.webrob.spatial.config;

import com.webrob.spatial.rest.InitDataRestService;
import com.webrob.spatial.rest.IssueRestService;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Robert on 2014-12-28.
 */
@ApplicationPath("SpatialDatabaseUsage")
public class ApplicationConfig extends Application
{
    private final Set<Class<?>> classes;

    public ApplicationConfig()
    {
	Set<Class<?>> c = new HashSet<>();
	c.add(IssueRestService.class);
	c.add(InitDataRestService.class);
	c.add(JacksonJsonProvider.class);

	classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses()
    {
	return classes;
    }
}