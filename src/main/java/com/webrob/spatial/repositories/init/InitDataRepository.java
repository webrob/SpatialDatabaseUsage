package com.webrob.spatial.repositories.init;

import com.webrob.spatial.domain.InitValues;
import com.webrob.spatial.repositories.ConnectionManager;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Robert on 2015-01-01.
 */
public abstract class InitDataRepository extends ConnectionManager<InitValues>
{

    public List<InitValues> getInitValues()
    {
	return doAllTransaction();
    }

    @Override
    protected List<InitValues> doQuery() throws SQLException
    {
	return queryIssues();
    }

    protected abstract List<InitValues> queryIssues() throws SQLException;

}
