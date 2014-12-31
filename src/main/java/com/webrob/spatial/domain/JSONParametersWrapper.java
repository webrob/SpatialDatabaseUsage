package com.webrob.spatial.domain;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by Robert on 2014-12-27.
 */

public class JSONParametersWrapper
{
    private IssueSearchParameters searchParameters;

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
		searchParameters = mapper.readValue(json, IssueSearchParameters.class);
	    }
	    catch (IOException e)
	    {
		e.printStackTrace();
	    }
	}
    }

    public IssueSearchParameters getIssueSearchParameters()
    {
	return searchParameters;
    }
}