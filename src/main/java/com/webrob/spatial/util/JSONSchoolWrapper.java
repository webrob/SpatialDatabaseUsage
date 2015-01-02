package com.webrob.spatial.util;

import com.webrob.spatial.domain.SearchIssueParameters;
import com.webrob.spatial.domain.SearchSchoolParameters;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by Robert on 2015-01-02.
 */
public class JSONSchoolWrapper
{
    private SearchSchoolParameters schoolParameters;

    public JSONSchoolWrapper()
    {
    }

    /**
     * Deserializes an Object of class MyClass from its JSON representation
     */
    public JSONSchoolWrapper(String json)
    {
	if (json != null)
	{
	    ObjectMapper mapper = new ObjectMapper(); //Jackson's JSON marshaller
	    schoolParameters = null;
	    try
	    {
		schoolParameters = mapper.readValue(json, SearchSchoolParameters.class);
	    }
	    catch (IOException e)
	    {
		e.printStackTrace();
	    }
	}
    }

    public SearchSchoolParameters getSearchSchoolParameters()
    {
	return schoolParameters;
    }
}
