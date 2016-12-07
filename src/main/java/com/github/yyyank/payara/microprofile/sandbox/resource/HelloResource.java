package com.github.yyyank.payara.microprofile.sandbox.resource;

import com.github.yyyank.payara.microprofile.sandbox.cdi.ConcurrentBean;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloResource {

    @Inject
    ConcurrentBean cb;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String say(@QueryParam("name") String name) {
        cb.listen();
        return String.format("Hello, %s!", name);
    }
}
