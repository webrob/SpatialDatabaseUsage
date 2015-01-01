package com.webrob.spatial.repositories;

import com.webrob.spatial.domain.AreaStatistics;
import com.webrob.spatial.domain.SearchAreaStatistics;

import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 2014-12-31.
 */
@Stateless
public class AreaRepositoryImpl extends AreaRepository
{
    @Override
    protected List<AreaStatistics> queryIssues(SearchAreaStatistics searchAreaStatistics) throws SQLException
    {
	List<AreaStatistics> areaStatistics = new ArrayList<>();
	areaStatistics.add(new AreaStatistics());
	return areaStatistics;
    }
}
