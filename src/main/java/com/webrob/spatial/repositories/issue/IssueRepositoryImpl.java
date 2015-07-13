package com.webrob.spatial.repositories.issue;

import com.webrob.spatial.domain.Issue;
import com.webrob.spatial.domain.SearchIssueParameters;

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
    String selectQuery = "SELECT i.id, X(i.latLng) latitude, Y(i.latLng) longitude, i.summary, i.description, i.num_votes,"
		    + "i.num_comments, i.num_views, i.source, i.created_time, i.tag_type FROM issue i WHERE i.city = ?";

    private String prepareSelectQuery(SearchIssueParameters parameters)
    {
	StringBuilder query = new StringBuilder(selectQuery);

	if (parameters.isSourceSelected())
	{
	    query.append(" AND i.source = ?");
	}
	if (parameters.isTagTypeSelected())
	{
	    query.append(" AND i.tag_type = ?");
	}
	if (parameters.isVoteAmountSelected())
	{
	    query.append(" AND i.num_votes >= ?");
	    query.append(" AND i.num_votes <= ?");
	}
	if (parameters.isViewsAmountSelected())
	{
	    query.append(" AND i.num_views >= ?");
	    query.append(" AND i.num_views <= ?");
	}
	if (parameters.isCommentsAmountSelected())
	{
	    query.append(" AND i.num_comments >= ?");
	    query.append(" AND i.num_comments <= ?");
	}
	if (parameters.isCreatedTimeSelected())
	{
	    query.append(" AND i.created_time >= ?");
	    query.append(" AND i.created_time <= ?");
	}

	return query.toString();
    }

    private void setPrepareStatementParameters(PreparedStatement preparedStatement, SearchIssueParameters parameters)
		    throws SQLException
    {
	int index = 0;
	preparedStatement.setString(++index, parameters.getCity());
	if (parameters.isSourceSelected())
	{
	    preparedStatement.setString(++index, parameters.getSource());
	}
	if (parameters.isTagTypeSelected())
	{
	    preparedStatement.setString(++index, parameters.getTagType());
	}
	if (parameters.isVoteAmountSelected())
	{
	    preparedStatement.setInt(++index, parameters.getMinVotesAmount());
	    preparedStatement.setInt(++index, parameters.getMaxVotesAmount());
	}
	if (parameters.isViewsAmountSelected())
	{
	    preparedStatement.setInt(++index, parameters.getMinViewsAmount());
	    preparedStatement.setInt(++index, parameters.getMaxViewsAmount());
	}
	if (parameters.isCommentsAmountSelected())
	{
	    preparedStatement.setInt(++index, parameters.getMinCommentsAmount());
	    preparedStatement.setInt(++index, parameters.getMaxCommentsAmount());
	}
	if (parameters.isCreatedTimeSelected())
	{
	    preparedStatement.setString(++index, parameters.getMinCreatedTime());
	    preparedStatement.setString(++index, parameters.getMaxCreatedTime());
	}
    }

    @Override
    public List<Issue> queryIssues(SearchIssueParameters searchIssueParameters) throws SQLException
    {
	List<Issue> issues = new ArrayList<>();
	String query = prepareSelectQuery(searchIssueParameters);
	try (PreparedStatement preparedStatement = connection.prepareStatement(query))
	{
	    setPrepareStatementParameters(preparedStatement, searchIssueParameters);
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

		    String source = resultSet.getString("source");
		    issue.setSource(source);

		    String createdTime = resultSet.getString("created_time");
		    issue.setCreatedTime(createdTime);

		    issues.add(issue);
		}
	    }
	    return issues;
	}
    }
}
