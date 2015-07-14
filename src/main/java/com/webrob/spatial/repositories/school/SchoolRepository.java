package com.webrob.spatial.repositories.school;

import com.webrob.spatial.domain.School;
import com.webrob.spatial.domain.SearchSchoolParameters;
import com.webrob.spatial.repositories.Repository;

import javax.ejb.Stateless;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 2015-01-02.
 */
@Stateless @SchoolAnnotation
public class SchoolRepository extends Repository<School, SearchSchoolParameters>
{
    protected String query = "select s.name, s.lograde, s.higrade from school s"
		    + " WHERE ST_Distance((GeomFromText(?)), s.latLng) < ?";

    @Override
    protected List<School> queryIssues(SearchSchoolParameters searchSchoolParameters) throws SQLException
    {
	List<School> schools = new ArrayList<>();

	try (PreparedStatement preparedStatement = connection.prepareStatement(query))
	{
	    setPrepareStatementParameters(preparedStatement, searchSchoolParameters);
	    try (ResultSet resultSet = preparedStatement.executeQuery())
	    {
		while (resultSet.next())
		{
		    School school = new School();

		    String name = resultSet.getString("name");
		    school.setName(name);

		    String lograde = resultSet.getString("lograde");
		    school.setLowestClassType(lograde);

		    int higrade = resultSet.getInt("higrade");
		    school.setClassesAmount(higrade);

		    schools.add(school);
		}
	    }
	}
	return schools;
    }

    private void setPrepareStatementParameters(PreparedStatement preparedStatement, SearchSchoolParameters searchSchoolParameters)
		    throws SQLException
    {
	String pointQueryPart = getPointQueryPart(searchSchoolParameters);
	preparedStatement.setString(1, pointQueryPart);

	double distance = searchSchoolParameters.getDistance();
	preparedStatement.setDouble(2, distance);
    }

    private String getPointQueryPart(SearchSchoolParameters searchSchoolParameters)
    {
	StringBuilder query = new StringBuilder("POINT(");

	double latitude = searchSchoolParameters.getLatitude();
	double longitude = searchSchoolParameters.getLongitude();
	query.append(latitude).append(" ").append(longitude).append(")");

	return query.toString();
    }
}
