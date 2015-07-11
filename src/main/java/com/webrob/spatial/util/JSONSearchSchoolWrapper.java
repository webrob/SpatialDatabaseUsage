package com.webrob.spatial.util;

import com.webrob.spatial.domain.SearchSchoolParameters;

/**
 * Created by Robert on 2015-01-02.
 */
public class JSONSearchSchoolWrapper extends JSONWrapper<SearchSchoolParameters>
{
    public JSONSearchSchoolWrapper(String json)
    {
	super(json, SearchSchoolParameters.class);
    }
}
