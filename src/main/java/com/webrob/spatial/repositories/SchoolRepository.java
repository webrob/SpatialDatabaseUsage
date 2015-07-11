package com.webrob.spatial.repositories;

import com.webrob.spatial.domain.School;
import com.webrob.spatial.domain.SearchSchoolParameters;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Robert on 2015-01-02.
 */
public abstract class SchoolRepository extends ConnectionManager<School>
{
    private SearchSchoolParameters searchSchoolParameters;

    public List<School> getAreaStatistics(SearchSchoolParameters searchSchoolParameters)
    {
	this.searchSchoolParameters = searchSchoolParameters;
	return doAllTransaction();
    }

    @Override
    protected List<School> doQuery() throws SQLException
    {
	return queryIssues(searchSchoolParameters);
    }

    protected abstract List<School> queryIssues(SearchSchoolParameters searchSchoolParameters) throws SQLException;

}
