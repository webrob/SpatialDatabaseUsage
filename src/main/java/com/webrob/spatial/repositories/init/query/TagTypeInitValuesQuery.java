package com.webrob.spatial.repositories.init.query;

import com.webrob.spatial.domain.InitValues;

import java.sql.Connection;

/**
 * Created by Robert on 2015-07-13.
 */
public class TagTypeInitValuesQuery extends InitValuesQuery
{
    protected String tagTypesQuery = "select i.tag_type as " + initValueName + " from issue i group by i.tag_type ORDER BY  i.tag_type";

    public TagTypeInitValuesQuery(Connection connection, InitValues initValues)
    {
	super(connection, initValues);
    }

    @Override protected void addToInitValues(String value)
    {
	initValues.addTagType(value);
    }

    @Override protected String getQuery()
    {
	return tagTypesQuery;
    }
}
