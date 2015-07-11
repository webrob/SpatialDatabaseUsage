package com.webrob.spatial.web.rest;

import com.webrob.spatial.domain.InitValues;
import com.webrob.spatial.repositories.InitDataRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Robert on 2015-01-01.
 */
@Path("init")
@Stateless
public class InitDataRestService
{
    @Inject
    private InitDataRepository initDataRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<InitValues> getSourceValues()
    {
        return initDataRepository.getInitValues();
    }

}
