package com.webrob.spatial.util;

import com.webrob.spatial.domain.SearchAreaStatistics;

/**
 * Created by Robert on 2014-12-31.
 */

public class JSONAreaStatisticsWrapper extends  JSONWrapper<SearchAreaStatistics>
{
    public JSONAreaStatisticsWrapper(String json)
    {
	super(json, SearchAreaStatistics.class);
    }
}
