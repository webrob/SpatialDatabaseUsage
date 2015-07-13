package com.webrob.spatial.repositories.init.query;

import com.webrob.spatial.domain.InitValues;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Robert on 2015-07-13.
 */
public abstract class InitValuesQuery
{
    protected String initValueName = "init_value";

    protected final Connection connection;
    protected final InitValues initValues;

    public InitValuesQuery(Connection connection, InitValues initValues) {

	this.connection = connection;
	this.initValues = initValues;
    }

    public void queryInitValues() throws SQLException
    {
	String query = getQuery();
	try (PreparedStatement preparedStatement = connection.prepareStatement(query))
	{
	    try (ResultSet resultSet = preparedStatement.executeQuery())
	    {
		while (resultSet.next())
		{
		    doSthWithResult(resultSet);
		}
	    }
	}
    }

    protected void doSthWithResult(ResultSet resultSet) throws SQLException
    {
	String value = resultSet.getString(initValueName);
	addToInitValues(value);
    }

    protected abstract void addToInitValues(String value);

    protected abstract String getQuery();
}
