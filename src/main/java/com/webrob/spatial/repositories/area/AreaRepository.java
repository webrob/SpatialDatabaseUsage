package com.webrob.spatial.repositories.area;

import com.webrob.spatial.domain.AreaStatistics;
import com.webrob.spatial.domain.SearchAreaStatistics;
import com.webrob.spatial.repositories.ConnectionManager;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Robert on 2014-12-31.
 */
public abstract class AreaRepository extends ConnectionManager<AreaStatistics>
{
    private SearchAreaStatistics searchAreaStatistics;

    public List<AreaStatistics> getAreaStatistics(SearchAreaStatistics searchAreaStatistics)
    {
	this.searchAreaStatistics = searchAreaStatistics;
	return doAllTransaction();
    }

    @Override
    protected List<AreaStatistics> doQuery() throws SQLException
    {
	return queryIssues(searchAreaStatistics);
    }

    protected abstract List<AreaStatistics> queryIssues(SearchAreaStatistics searchAreaStatistics) throws SQLException;

}
