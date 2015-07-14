package com.webrob.spatial.rest;

import com.webrob.spatial.domain.*;
import com.webrob.spatial.repositories.Repository;
import com.webrob.spatial.repositories.area.AreaAnnotation;
import com.webrob.spatial.repositories.issue.IssueAnnotation;
import com.webrob.spatial.repositories.school.SchoolAnnotation;
import com.webrob.spatial.util.JSONAreaStatisticsWrapper;
import com.webrob.spatial.util.JSONPSearchIssuesWrapper;
import com.webrob.spatial.util.JSONSearchSchoolWrapper;

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
    @Inject @IssueAnnotation
    private Repository<Issue, SearchIssueParameters> issueRepository;

    @Inject @AreaAnnotation
    private Repository<AreaStatistics, SearchAreaStatistics> areaRepository;

    @Inject @SchoolAnnotation
    private Repository<School, SearchSchoolParameters> schoolRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Issue> getAllIssues(@QueryParam("parameters")JSONPSearchIssuesWrapper JSONPSearchIssuesWrapper) throws SQLException
    {
        SearchIssueParameters searchIssueParameters = JSONPSearchIssuesWrapper.getParameters();
        return issueRepository.getData(searchIssueParameters);
    }

    @GET
    @Path("area")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AreaStatistics> getAreaStatistics(@QueryParam("parameters") JSONAreaStatisticsWrapper jsonAreaStatisticsWrapper) throws SQLException
    {
        SearchAreaStatistics searchAreaStatistics = jsonAreaStatisticsWrapper.getParameters();
        return areaRepository.getData(searchAreaStatistics);
    }

    @GET
    @Path("school")
    @Produces(MediaType.APPLICATION_JSON)
    public List<School> getSchools(@QueryParam("parameters") JSONSearchSchoolWrapper jsonSearchSchoolWrapper) throws SQLException
    {
        SearchSchoolParameters searchSchoolParameters = jsonSearchSchoolWrapper.getParameters();
        return schoolRepository.getData(searchSchoolParameters);
    }
}
