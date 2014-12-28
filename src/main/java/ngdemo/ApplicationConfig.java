package ngdemo;

import ngdemo.web.rest.UserRestService;
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

    // ======================================
    // =             Attributes             =
    // ======================================

    private final Set<Class<?>> classes;

    // ======================================
    // =            Constructors            =
    // ======================================

    public ApplicationConfig() {
	HashSet<Class<?>> c = new HashSet<>();
	c.add(UserRestService.class);

	c.add(JacksonJsonProvider.class);

	classes = Collections.unmodifiableSet(c);
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    @Override
    public Set<Class<?>> getClasses() {
	return classes;
    }
}