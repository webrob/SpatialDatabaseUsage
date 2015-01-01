package com.webrob.spatial.domain;

/**
 * Created by Robert on 2014-12-31.
 */
public class SearchIssueParameters
{
    public String getTagType()
    {
	return tagType;
    }

    public void setTagType(String tagType)
    {
	this.tagType = tagType;
    }

    public int getMinVotesAmount()
    {
	return minVotesAmount;
    }

    public void setMinVotesAmount(int minVotesAmount)
    {
	this.minVotesAmount = minVotesAmount;
    }

    public int getMinCommentsAmount()
    {
	return minCommentsAmount;
    }

    public void setMinCommentsAmount(int minCommentsAmount)
    {
	this.minCommentsAmount = minCommentsAmount;
    }

    public int getMinViewsAmount()
    {
	return minViewsAmount;
    }

    public void setMinViewsAmount(int minViewsAmount)
    {
	this.minViewsAmount = minViewsAmount;
    }

    public int getMaxVotesAmount()
    {
	return maxVotesAmount;
    }

    public void setMaxVotesAmount(int maxVotesAmount)
    {
	this.maxVotesAmount = maxVotesAmount;
    }

    public int getMaxCommentsAmount()
    {
	return maxCommentsAmount;
    }

    public void setMaxCommentsAmount(int maxCommentsAmount)
    {
	this.maxCommentsAmount = maxCommentsAmount;
    }

    public int getMaxViewsAmount()
    {
	return maxViewsAmount;
    }

    public void setMaxViewsAmount(int maxViewsAmount)
    {
	this.maxViewsAmount = maxViewsAmount;
    }

    public String getSource()
    {
	return source;
    }

    public void setSource(String source)
    {
	this.source = source;
    }

    public String getMinCreatedTime()
    {
	return minCreatedTime;
    }

    public void setMinCreatedTime(String minCreatedTime)
    {
	this.minCreatedTime = minCreatedTime;
    }

    public String getMaxCreatedTime()
    {
	return maxCreatedTime;
    }

    public void setMaxCreatedTime(String maxCreatedTime)
    {
	this.maxCreatedTime = maxCreatedTime;
    }

    private boolean voteAmountSelected;
    private boolean commentsAmountSelected;
    private boolean viewsAmountSelected;
    private boolean createdTimeSelected;
    private boolean sourceSelected;
    private boolean tagTypeSelected;

    public boolean isTagTypeSelected()
    {
        return tagTypeSelected;
    }

    public void setTagTypeSelected(boolean isTagTypeSelected)
    {
        this.tagTypeSelected = isTagTypeSelected;
    }

    public boolean isSourceSelected()
    {
        return sourceSelected;
    }

    public void setSourceSelected(boolean isSourceSelected)
    {
        this.sourceSelected = isSourceSelected;
    }

    public boolean isCreatedTimeSelected()
    {
        return createdTimeSelected;
    }

    public void setCreatedTimeSelected(boolean isCreatedTimeSelected)
    {
        this.createdTimeSelected = isCreatedTimeSelected;
    }

    public boolean isViewsAmountSelected()
    {
        return viewsAmountSelected;
    }

    public void setViewsAmountSelected(boolean isViewsAmountSelected)
    {
        this.viewsAmountSelected = isViewsAmountSelected;
    }

    public boolean isCommentsAmountSelected()
    {
        return commentsAmountSelected;
    }

    public void setCommentsAmountSelected(boolean isCommentsAmountSelected)
    {
        this.commentsAmountSelected = isCommentsAmountSelected;
    }

    public boolean isVoteAmountSelected()
    {
        return voteAmountSelected;
    }

    public void setVoteAmountSelected(boolean isVoteAmountSelected)
    {
        this.voteAmountSelected = isVoteAmountSelected;
    }



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

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    private String city;

}
