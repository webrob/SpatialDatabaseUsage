package com.webrob.spatial.repositories;

import com.webrob.spatial.domain.InitValues;

import javax.ejb.Stateless;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 2015-01-01.
 */
@Stateless
public class InitDataRepositoryImpl extends InitDataRepository
{
    protected String sourcesQuery = "select i.source from issue i group by i.source";
    protected String tagTypesQuery = "select i.tag_type from issue i group by i.tag_type";
    protected String citiesQuery = "select i.city from issue i group by i.city";
    protected String maxValuesQuery = "select max(i.num_votes) max_votes ,max(num_comments) max_comments, max(i.num_views) max_views, max(i.created_time) max_created_time, min(i.created_time) min_created_time from issue i";

    @Override
    protected List<InitValues> queryIssues() throws SQLException
    {
	List<InitValues> allInitValues = new ArrayList<>();
	InitValues initValues = new InitValues();
	try (PreparedStatement preparedStatement = connection.prepareStatement(sourcesQuery))
	{
	    try (ResultSet resultSet = preparedStatement.executeQuery())
	    {
		while (resultSet.next())
		{
		    String source = resultSet.getString("source");
		    initValues.addSource(source);
		}
	    }
	}

	try (PreparedStatement preparedStatement = connection.prepareStatement(tagTypesQuery))
	{
	    try (ResultSet resultSet = preparedStatement.executeQuery())
	    {
		while (resultSet.next())
		{
		    String tagType = resultSet.getString("tag_type");
		    initValues.addTagType(tagType);
		}
	    }
	}


	try (PreparedStatement preparedStatement = connection.prepareStatement(citiesQuery))
	{

	    try (ResultSet resultSet = preparedStatement.executeQuery())
	    {
		while (resultSet.next())
		{
		    String tagType = resultSet.getString("city");
		    initValues.addCity(tagType);
		}
	    }
	}


	try (PreparedStatement preparedStatement = connection.prepareStatement(maxValuesQuery))
	{

	    try (ResultSet resultSet = preparedStatement.executeQuery())
	    {
		while (resultSet.next())
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
	    }
	}
	allInitValues.add(initValues);
	return allInitValues;
    }
}
