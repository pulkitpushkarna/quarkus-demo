package org.quarkus.demo;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/mobiles")
public class MobileResource {

    List<String> mobiles = new ArrayList<>(Arrays.asList("iPhone", "Samsung", "OnePlus"));

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMobile() {
        return Response.ok(mobiles).build();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response saveMobile(String mobileName) {
        mobiles.add(mobileName);
        return Response.ok(mobiles).build();
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public Response updateMobile(@QueryParam("oldName") String oldName, @QueryParam("newName") String newName) {
        int index = mobiles.indexOf(oldName);
        mobiles.set(index, newName);
        return Response.ok(mobiles).build();
    }

    @DELETE
    @Path("/{name}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response deleteMobile(@PathParam("name") String name) {
        mobiles.remove(name);
        return Response.ok(mobiles).build();
    }
}
