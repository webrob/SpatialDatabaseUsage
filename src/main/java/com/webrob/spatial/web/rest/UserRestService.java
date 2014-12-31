package com.webrob.spatial.web.rest;

import com.webrob.spatial.domain.Issue;
import com.webrob.spatial.domain.IssueSearchParameters;
import com.webrob.spatial.domain.JSONParametersWrapper;
import com.webrob.spatial.repositories.IssueRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/issues")
@Stateless
public class UserRestService
{
    @Inject
    private IssueRepository issueRepository;


    @GET
    @Path("numberOfUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public int getNumberOfUsers()
    {
	return 0;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Issue> getAllUsersInJSON(@QueryParam("parameters")JSONParametersWrapper jSONParametersWrapper) throws SQLException
    {
        IssueSearchParameters issueSearchParameters = jSONParametersWrapper.getIssueSearchParameters();

        List<Issue> allIssues = issueRepository.getAllIssues(issueSearchParameters);
        return allIssues;
    }



}
