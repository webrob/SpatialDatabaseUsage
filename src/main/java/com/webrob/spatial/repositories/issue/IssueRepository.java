package com.webrob.spatial.repositories.issue;

import com.webrob.spatial.domain.Issue;
import com.webrob.spatial.domain.SearchIssueParameters;
import com.webrob.spatial.repositories.ConnectionManager;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Robert on 2014-12-29.
 */
public abstract class IssueRepository extends ConnectionManager<Issue>
{
    private SearchIssueParameters searchIssueParameters;

    public List<Issue> getAllIssues(SearchIssueParameters searchIssueParameters)
    {
        this.searchIssueParameters = searchIssueParameters;
        return doAllTransaction();
    }

    @Override
    protected List<Issue> doQuery() throws SQLException
    {
        return queryIssues(searchIssueParameters);
    }

    protected abstract List<Issue> queryIssues(SearchIssueParameters searchIssueParameters) throws SQLException;
}
