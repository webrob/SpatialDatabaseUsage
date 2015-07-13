package com.webrob.spatial.repositories.init.query;

import com.webrob.spatial.domain.InitValues;

import java.sql.Connection;

/**
 * Created by Robert on 2015-07-13.
 */
public class SourceInitValuesQuery extends InitValuesQuery
{
    protected String sourcesQuery = "select i.source as " + initValueName+ " from issue i group by i.source ORDER BY i.source";

    public SourceInitValuesQuery(Connection connection, InitValues initValues)
    {
	super(connection, initValues);
    }

    @Override protected void addToInitValues(String value)
    {
	initValues.addSource(value);
    }

    @Override protected String getQuery()
    {
	return sourcesQuery;
    }
}
