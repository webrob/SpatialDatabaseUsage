package com.webrob.spatial.repositories.init;

import com.webrob.spatial.domain.InitValues;
import com.webrob.spatial.repositories.init.query.*;

import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 2015-01-01.
 */
@Stateless
public class InitDataRepositoryImpl extends InitDataRepository
{
    @Override
    protected List<InitValues> queryIssues() throws SQLException
    {
	List<InitValues> allInitValues = new ArrayList<>();
	InitValues initValues = new InitValues();

	InitValuesQuery valuesQuery = new SourceInitValuesQuery(connection, initValues);
	valuesQuery.queryInitValues();

	valuesQuery = new TagTypeInitValuesQuery(connection, initValues);
	valuesQuery.queryInitValues();

	valuesQuery = new CityInitValuesQuery(connection, initValues);
	valuesQuery.queryInitValues();

	valuesQuery = new MaxInitValuesQuery(connection, initValues);
	valuesQuery.queryInitValues();

	allInitValues.add(initValues);
	return allInitValues;
    }
}
