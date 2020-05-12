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

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * JAX-RS Example
 * <p/>
 * This class produces a RESTful service to read/write the contents of the members table.
 */
@Path("/members")
@Api(value = "/members", description = "Operations about pets")

@RequestScoped
public class MemberResourceRESTService {

    @GET
    @Path("/{name}")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied"),
    	      @ApiResponse(code = 404, message = "Pet not found") })
    @Produces(MediaType.APPLICATION_JSON)
    public Response lookupMemberByName(@PathParam("name") String name) {
    	
    	Response.ResponseBuilder builder = null;
    	Map<String, String> responseObj = new HashMap<>();
    	
    	responseObj.put("name", name);
    	builder = Response.status(Response.Status.OK).entity(responseObj);
    	 return builder.build();
    }
}
