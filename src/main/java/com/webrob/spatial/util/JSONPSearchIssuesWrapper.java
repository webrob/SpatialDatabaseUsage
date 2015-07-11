package com.webrob.spatial.util;

import com.webrob.spatial.domain.SearchIssueParameters;

/**
 * Created by Robert on 2014-12-27.
 */

public class JSONPSearchIssuesWrapper extends JSONWrapper<SearchIssueParameters>
{
    public JSONPSearchIssuesWrapper(String json)
    {
	super(json, SearchIssueParameters.class);
    }
}