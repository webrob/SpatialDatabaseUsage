package com.webrob.spatial.repositories;

import com.webrob.spatial.domain.Issue;
import com.webrob.spatial.domain.IssueSearchParameters;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Robert on 2014-12-29.
 */
public abstract class IssueRepository extends ConnectionManager<Issue>
{
    private IssueSearchParameters issueSearchParameters;

    public List<Issue> getAllIssues(IssueSearchParameters issueSearchParameters)
    {
        this.issueSearchParameters = issueSearchParameters;
        return doAllTransaction();
    }

    @Override
    protected List<Issue> doQuery() throws SQLException
    {
        return queryIssues(issueSearchParameters);
    }

    protected abstract List<Issue> queryIssues(IssueSearchParameters issueSearchParameters) throws SQLException;
}
