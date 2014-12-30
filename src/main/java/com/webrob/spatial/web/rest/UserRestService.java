package com.webrob.spatial.web.rest;

import com.webrob.spatial.domain.Issue;
import com.webrob.spatial.repositories.IssueRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/users")
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
    public List<Issue> getAllUsersInJSON() throws SQLException
    {
        List<Issue> allIssues = issueRepository.getAllIssues();
        return allIssues;
    }
}
