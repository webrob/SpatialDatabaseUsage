package com.webrob.spatial.util;

import com.webrob.spatial.domain.SearchAreaStatistics;
import com.webrob.spatial.domain.SearchIssueParameters;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by Robert on 2014-12-31.
 */

public class JSONAreaStatisticsWrapper
{
    private SearchAreaStatistics  areaStatistics;

    public JSONAreaStatisticsWrapper()
    {
    }

    /**
     * Deserializes an Object of class MyClass from its JSON representation
     */
    public JSONAreaStatisticsWrapper(String json)
    {
	if (json != null)
	{
	    ObjectMapper mapper = new ObjectMapper(); //Jackson's JSON marshaller
	    areaStatistics = null;
	    try
	    {
		areaStatistics = mapper.readValue(json, SearchAreaStatistics.class);
	    }
	    catch (IOException e)
	    {
		e.printStackTrace();
	    }
	}
    }

    public SearchAreaStatistics getSearchAreaStatistics()
    {
	return areaStatistics;
    }
}
