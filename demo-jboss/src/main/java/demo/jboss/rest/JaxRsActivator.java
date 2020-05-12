/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.jboss.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * A class extending {@link Application} and annotated with @ApplicationPath is the Java EE 7 "no XML" approach to activating
 * JAX-RS.
 *
 * <p>
 * Resources are served relative to the servlet path specified in the {@link ApplicationPath} annotation.
 * </p>
 */
@ApplicationPath("/rest")
public class JaxRsActivator extends Application {
    /* class body intentionally left blank */
	
	public JaxRsActivator() {
	    BeanConfig beanConfig = new BeanConfig();
	    beanConfig.setVersion("1.0.0");
	    beanConfig.setSchemes(new String[]{"http","https"});
	    beanConfig.setBasePath("/demo-jboss/rest");
	    beanConfig.setResourcePackage(MemberResourceRESTService.class.getPackage().getName());
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
        resources.add(MemberResourceRESTService.class);
    }

}