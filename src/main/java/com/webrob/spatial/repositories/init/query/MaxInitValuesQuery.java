package com.webrob.spatial.repositories.init.query;

import com.webrob.spatial.domain.InitValues;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Robert on 2015-07-13.
 */
public class MaxInitValuesQuery extends InitValuesQuery
{
    protected String maxValuesQuery = "select max(i.num_votes) max_votes ,max(num_comments) max_comments, max(i.num_views) max_views, max(i.created_time) max_created_time, min(i.created_time) min_created_time from issue i";

    public MaxInitValuesQuery(Connection connection, InitValues initValues)
    {
	super(connection, initValues);
    }

    @Override protected void addToInitValues(String value) {}

    @Override protected void doSthWithResult(ResultSet resultSet) throws SQLException
    {
	int votesAmount = resultSet.getInt("max_votes");
	initValues.setVotesAmount(votesAmount);

	int commentsAmount = resultSet.getInt("max_comments");
	initValues.setCommentsAmount(commentsAmount);

	int viewsAmount = resultSet.getInt("max_views");
	initValues.setViewsAmount(viewsAmount);

	String maxCreatedTime = resultSet.getString("max_created_time");
	initValues.setMaxCreatedTime(maxCreatedTime);

	String minCreatedTime = resultSet.getString("min_created_time");
	initValues.setMinCreatedTime(minCreatedTime);
    }


    @Override protected String getQuery()
    {
	return maxValuesQuery;
    }
}
