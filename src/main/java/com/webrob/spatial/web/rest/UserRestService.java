package com.webrob.spatial.web.rest;

import com.webrob.spatial.domain.AreaStatistics;
import com.webrob.spatial.domain.Issue;
import com.webrob.spatial.domain.SearchAreaStatistics;
import com.webrob.spatial.domain.SearchIssueParameters;
import com.webrob.spatial.repositories.AreaRepository;
import com.webrob.spatial.util.JSONAreaStatisticsWrapper;
import com.webrob.spatial.util.JSONParametersWrapper;
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

    @Inject
    private AreaRepository areaRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Issue> getAllIssues(@QueryParam("parameters")JSONParametersWrapper jsonParametersWrapper) throws SQLException
    {
        SearchIssueParameters searchIssueParameters = jsonParametersWrapper.getIssueSearchParameters();

        List<Issue> allIssues = issueRepository.getAllIssues(searchIssueParameters);
        return allIssues;
    }


    @GET
    @Path("area")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AreaStatistics> getAreaStatistics(@QueryParam("parameters")JSONAreaStatisticsWrapper jsonAreaStatisticsWrapper) throws SQLException
    {
        SearchAreaStatistics searchAreaStatistics = jsonAreaStatisticsWrapper.getSearchAreaStatistics();
        List<AreaStatistics> areaStatistics = areaRepository.getAreaStatistics(searchAreaStatistics);

        return areaStatistics;
    }


}
