package com.webrob.spatial.domain;

import lombok.Data;

/**
 * Created by Robert on 2014-12-31.
 */
public @Data class SearchIssueParameters
{
    private boolean voteAmountSelected;
    private boolean commentsAmountSelected;
    private boolean viewsAmountSelected;
    private boolean createdTimeSelected;
    private boolean sourceSelected;
    private boolean tagTypeSelected;

    private int minVotesAmount;
    private int minCommentsAmount;
    private int minViewsAmount;

    private int maxVotesAmount;
    private int maxCommentsAmount;
    private int maxViewsAmount;

    private String source;
    private String minCreatedTime;
    private String maxCreatedTime;
    private String tagType;
    private String city;

    public String getMaxCreatedTime()
    {
        return maxCreatedTime + " 23:59:59";
    }

}
