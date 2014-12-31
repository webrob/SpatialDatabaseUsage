package com.webrob.spatial.util;

import com.webrob.spatial.domain.SearchIssueParameters;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by Robert on 2014-12-27.
 */

public class JSONParametersWrapper
{
    private SearchIssueParameters searchParameters;

    public JSONParametersWrapper()
    {
    }

    /**
     * Deserializes an Object of class MyClass from its JSON representation
     */
    public JSONParametersWrapper(String json)
    {
	if (json != null)
	{
	    ObjectMapper mapper = new ObjectMapper(); //Jackson's JSON marshaller
	    searchParameters = null;
	    try
	    {
		searchParameters = mapper.readValue(json, SearchIssueParameters.class);
	    }
	    catch (IOException e)
	    {
		e.printStackTrace();
	    }
	}
    }

    public SearchIssueParameters getIssueSearchParameters()
    {
	return searchParameters;
    }
}