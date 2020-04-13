package com.okta.quarkus.jwt;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/kayaks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KayakResource {
    private Set<Kayak> kayaks = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
    public KayakResource() {
        kayaks.add(new Kayak("NDK", "Romany", 17));
        kayaks.add(new Kayak("NDK", "Surf", 16));
        kayaks.add(new Kayak("P&H", "Scorpio HV", 15));
    }
    @GET
    public Set<Kayak> list() {
        return kayaks;
    }

//    @RolesAllowed({"Everyone"})
    @POST
    public Set<Kayak> add(Kayak kayak) {
        kayaks.add(kayak);
        return kayaks;
    }
//    @RolesAllowed({"Everyone"})
    @DELETE
    public Set<Kayak> delete(Kayak kayak) {
        kayaks.remove(kayak);
        return kayaks;
    }
}
