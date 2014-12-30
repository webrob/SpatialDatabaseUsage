package com.webrob.spatial.domain;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by Robert on 2014-12-27.
 */

public class JSONwrapper
{
    private Test o;

    public JSONwrapper()
    {
    }

    /**
     * Deserializes an Object of class MyClass from its JSON representation
     */
    public JSONwrapper(String json)
    {
	if (json != null)
	{
	    ObjectMapper mapper = new ObjectMapper(); //Jackson's JSON marshaller
	    o = null;
	    try
	    {
		o = mapper.readValue(json, Test.class);
	    }
	    catch (IOException e)
	    {
		e.printStackTrace();
	    }
	}
    }

    public Test getO()
    {
	return o;
    }
}