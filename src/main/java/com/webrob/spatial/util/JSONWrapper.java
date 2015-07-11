package com.webrob.spatial.util;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by Robert on 2015-07-11.
 */
public class JSONWrapper<T>
{
    private T parameters;

    public JSONWrapper()
    {
    }

    public JSONWrapper(String json, Class<T> parametersClass)
    {
	if (json != null)
	{
	    ObjectMapper mapper = new ObjectMapper();
	    parameters = null;

	    try
	    {
		parameters = mapper.readValue(json, parametersClass);
	    }
	    catch (IOException e)
	    {
		e.printStackTrace();
	    }
	}
    }

    public T getParameters()
    {
	return parameters;
    }
}
