package com.webrob.spatial.repositories.init.query;

import com.webrob.spatial.domain.InitValues;

import java.sql.Connection;

/**
 * Created by Robert on 2015-07-13.
 */
public class CityInitValuesQuery extends InitValuesQuery
{
    protected String citiesQuery = "select i.city as " + initValueName + " from issue i group by i.city ORDER BY i.city";

    public CityInitValuesQuery(Connection connection, InitValues initValues)
    {
	super(connection, initValues);
    }

    @Override protected void addToInitValues(String value)
    {
	initValues.addCity(value);
    }

    @Override protected String getQuery()
    {
	return citiesQuery;
    }
}
