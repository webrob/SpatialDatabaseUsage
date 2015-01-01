package com.webrob.spatial.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 2015-01-01.
 */
@XmlRootElement
public class InitValues
{
    public List<String> getCites()
    {
        return cites;
    }

    public void setCites(List<String> cites)
    {
        this.cites = cites;
    }

    private List<String> cites = new ArrayList<>();
    private List<String> sources = new ArrayList<>();
    private List<String> tagTypes = new ArrayList<>();
    private int votesAmount;
    private int commentsAmount;
    private int viewsAmount;
    private String maxCreatedTime;
    private String minCreatedTime;

    public List<String> getTagTypes()
    {
        return tagTypes;
    }

    public void setTagTypes(List<String> tagTypes)
    {
        this.tagTypes = tagTypes;
    }



    public List<String> getSources()
    {
	return sources;
    }

    public void setSources(List<String> sources)
    {
	this.sources = sources;
    }

    public void addSource(String source)
    {
	sources.add(source);
    }

    public void addCity(String city)
    {
        cites.add(city);
    }

    public void addTagType(String tagType)
    {
        tagTypes.add(tagType);
    }

    public void setVotesAmount(int votesAmount)
    {
        this.votesAmount = votesAmount;
    }

    public int getVotesAmount()
    {
        return votesAmount;
    }

    public void setCommentsAmount(int commentsAmount)
    {
        this.commentsAmount = commentsAmount;
    }

    public int getCommentsAmount()
    {
        return commentsAmount;
    }

    public void setViewsAmount(int viewsAmount)
    {
        this.viewsAmount = viewsAmount;
    }

    public int getViewsAmount()
    {
        return viewsAmount;
    }

    public void setMaxCreatedTime(String maxCreatedTime)
    {
        this.maxCreatedTime = maxCreatedTime;
    }

    public String getMaxCreatedTime()
    {
        return maxCreatedTime;
    }

    public void setMinCreatedTime(String minCreatedTime)
    {
        this.minCreatedTime = minCreatedTime;
    }

    public String getMinCreatedTime()
    {
        return minCreatedTime;
    }
}
