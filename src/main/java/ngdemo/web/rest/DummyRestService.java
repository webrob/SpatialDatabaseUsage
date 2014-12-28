package ngdemo.web.rest;


import ngdemo.domain.User;
import ngdemo.service.contract.DummyService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dummy")
public class DummyRestService {
    private final DummyService dummyService;

    @Inject
    public DummyRestService(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getDefaultDummyInJSON() {
        return dummyService.getDefaultUser();
    }
}
