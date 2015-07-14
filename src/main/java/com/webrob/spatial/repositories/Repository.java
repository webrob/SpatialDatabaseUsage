package com.webrob.spatial.repositories;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Robert on 2014-12-29.
 */
public abstract class Repository<CLASS, PARAM> extends ConnectionManager<CLASS>
{
    private PARAM searchIssueParameters;

    public List<CLASS> getData(PARAM searchIssueParameters)
    {
        this.searchIssueParameters = searchIssueParameters;
        return doAllTransaction();
    }

    @Override
    protected List<CLASS> doQuery() throws SQLException
    {
        return queryIssues(searchIssueParameters);
    }

    protected abstract List<CLASS> queryIssues(PARAM searchIssueParameters) throws SQLException;
}
