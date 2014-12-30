package com.webrob.spatial.repositories;

import com.webrob.spatial.domain.Issue;

import javax.ejb.Stateless;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 2014-12-29.
 */
@Stateless
public class IssueRepositoryImpl extends IssueRepository
{
    String selectQuery = "SELECT i.id, X(i.xy) latitude, Y(i.xy) longitude, i.summary, i.description, i.num_votes,"
		    + "i.num_comments, i.num_views, i.source, i.created_time, i.tag_type FROM issue i WHERE i.num_comments > ?1";

    @Override
    public List<Issue> queryIssues() throws SQLException
    {
	List<Issue> issues = new ArrayList<>();
	try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery))
	{
	    preparedStatement.setInt(1, 0);
	    try (ResultSet resultSet = preparedStatement.executeQuery())
	    {
		while (resultSet.next())
		{
		    Issue issue = new Issue();

		    String summary = resultSet.getString("summary");
		    issue.setSummary(summary);

		    double latitude = resultSet.getDouble("latitude");
		    issue.setLatitude(latitude);

		    double longitude = resultSet.getDouble("longitude");
		    issue.setLongitude(longitude);

		    int votesAmount = resultSet.getInt("num_votes");
		    issue.setVotesAmount(votesAmount);

		    int commentsAmount = resultSet.getInt("num_comments");
		    issue.setCommentsAmount(commentsAmount);

		    int viewsAmount = resultSet.getInt("num_views");
		    issue.setViewsAmount(viewsAmount);

		    String tagType = resultSet.getString("tag_type");
		    issue.setTagType(tagType);

		    String description = resultSet.getString("description");
		    issue.setDescription(description);

		    issues.add(issue);
		}
	    }
	    return issues;
	}
    }
}
