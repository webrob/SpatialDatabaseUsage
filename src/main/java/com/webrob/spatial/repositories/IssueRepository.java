package com.webrob.spatial.repositories;

import com.webrob.spatial.domain.Issue;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Robert on 2014-12-29.
 */
public abstract class IssueRepository extends ConnectionManager<Issue>
{
    public List<Issue> getAllIssues()
    {
        return doAllTransaction();
    }

    @Override
    protected List<Issue> doQuery() throws SQLException
    {
        return queryIssues();
    }

    protected abstract List<Issue> queryIssues() throws SQLException;
}
