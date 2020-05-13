package net.atos.sapg;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import io.swagger.jaxrs.config.BeanConfig;
import net.atos.sapg.rs.Root;

@ApplicationPath("/")
public class JaxRsActivator extends Application {
    /* class body intentionally left blank */
	
	public JaxRsActivator() {
	    BeanConfig beanConfig = new BeanConfig();
	    beanConfig.setVersion("1.0.0");
	    beanConfig.setSchemes(new String[]{"http","https"});
	    beanConfig.setBasePath("/sapg/rs");
	    beanConfig.setResourcePackage(Root.class.getPackage().getName());
	    beanConfig.setScan(true);
	}
	
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();

        classes.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        classes.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        addRestResources(classes);

        return classes;
    }

    /**
     * Here you can add your extra resources.
     *
     * @param resources
     */
    private void addRestResources(Set<Class<?>> resources) {
        resources.add(Root.class);
    }

}
