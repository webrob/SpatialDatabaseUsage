package com.webrob.spatial.repositories.area;

import com.webrob.spatial.domain.AreaStatistics;
import com.webrob.spatial.domain.SearchAreaStatistics;
import com.webrob.spatial.repositories.Repository;
import javafx.geometry.Point2D;

import javax.ejb.Stateless;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 2014-12-31.
 */
@Stateless @AreaAnnotation
public class AreaRepository extends Repository<AreaStatistics, SearchAreaStatistics>
{
    protected String query =
		    "select count(*) num_points, max(i.num_votes) max_votes, max(i.num_comments) max_comments, max(i.num_views) max_views,"
				    + " sum(i.num_votes) sum_votes, sum(i.num_comments) sum_comments, sum(i.num_views) sum_views, "
				    + " avg(i.num_votes) avg_votes, avg(i.num_comments) avg_comments, avg(i.num_views) avg_views from issue i"
				    + " where st_contains(GeomFromText(?), i.latLng)";

    private String getPolygonPartQuery(SearchAreaStatistics searchAreaStatistics)
    {
	StringBuilder polygon = new StringBuilder("Polygon((");
	List<Point2D> allPoints = searchAreaStatistics.getAllPoints();

	int index = 0;
	for (Point2D point2D : allPoints)
	{
	    index++;
	    polygon.append(point2D.getX()).append(" ");
	    polygon.append(point2D.getY());

	    if (index != allPoints.size())
	    {
		polygon.append(", ");
	    }
	}

	polygon.append("))");
	return polygon.toString();
    }

    @Override
    protected List<AreaStatistics> queryIssues(SearchAreaStatistics searchAreaStatistics) throws SQLException
    {
	List<AreaStatistics> areaStatisticsList = new ArrayList<>();
	try (PreparedStatement preparedStatement = connection.prepareStatement(query))
	{
	    String polygonPartQuery = getPolygonPartQuery(searchAreaStatistics);
	    preparedStatement.setString(1, polygonPartQuery);
	    try (ResultSet resultSet = preparedStatement.executeQuery())
	    {
		if (resultSet.next())
		{
		    AreaStatistics areaStatistics = new AreaStatistics();

		    int numPoints = resultSet.getInt("num_points");
		    areaStatistics.setPointsAmount(numPoints);

		    int maxVotes = resultSet.getInt("max_votes");
		    areaStatistics.setMaxVotesAmount(maxVotes);

		    int maxComments = resultSet.getInt("max_comments");
		    areaStatistics.setMaxCommentsAmount(maxComments);

		    int maxViews = resultSet.getInt("max_views");
		    areaStatistics.setMaxViewsAmount(maxViews);

		    int sumVotes = resultSet.getInt("sum_votes");
		    areaStatistics.setSumVotesAmount(sumVotes);

		    int sumComments = resultSet.getInt("sum_comments");
		    areaStatistics.setSumCommentsAmount(sumComments);

		    int sumViews = resultSet.getInt("sum_views");
		    areaStatistics.setSumViewsAmount(sumViews);

		    double avgVotes = resultSet.getDouble("avg_votes");
		    areaStatistics.setAvgVotesAmount(avgVotes);

		    double avgComments = resultSet.getDouble("avg_comments");
		    areaStatistics.setAvgCommentsAmount(avgComments);

		    double avgViews = resultSet.getDouble("avg_views");
		    areaStatistics.setAvgViewsAmount(avgViews);

		    areaStatisticsList.add(areaStatistics);
		}
	    }
	}
	return areaStatisticsList;
    }
}
