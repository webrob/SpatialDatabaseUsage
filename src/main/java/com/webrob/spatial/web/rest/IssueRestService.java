package com.webrob.spatial.web.rest;

import com.webrob.spatial.domain.*;
import com.webrob.spatial.repositories.AreaRepository;
import com.webrob.spatial.repositories.SchoolRepository;
import com.webrob.spatial.util.JSONAreaStatisticsWrapper;
import com.webrob.spatial.util.JSONParametersWrapper;
import com.webrob.spatial.repositories.IssueRepository;
import com.webrob.spatial.util.JSONSchoolWrapper;

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
public class IssueRestService
{
    @Inject
    private IssueRepository issueRepository;

    @Inject
    private AreaRepository areaRepository;

    @Inject
    private SchoolRepository schoolRepository;


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
    public List<AreaStatistics> getAreaStatistics(@QueryParam("parameters") JSONAreaStatisticsWrapper jsonAreaStatisticsWrapper) throws SQLException
    {
        SearchAreaStatistics searchAreaStatistics = jsonAreaStatisticsWrapper.getSearchAreaStatistics();
        List<AreaStatistics> areaStatistics = areaRepository.getAreaStatistics(searchAreaStatistics);

        return areaStatistics;
    }

    @GET
    @Path("school")
    @Produces(MediaType.APPLICATION_JSON)
    public List<School> getSchools(@QueryParam("parameters") JSONSchoolWrapper jsonSchoolWrapper) throws SQLException
    {
        SearchSchoolParameters searchSchoolParameters = jsonSchoolWrapper.getSearchSchoolParameters();
        List<School> schoolList = schoolRepository.getAreaStatistics(searchSchoolParameters);

        return schoolList;
    }


}
