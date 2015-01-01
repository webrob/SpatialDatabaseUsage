package com.webrob.spatial.domain;

import com.webrob.spatial.util.DateAdapter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Robert on 2014-12-29.
 */
@XmlRootElement
public class Issue
{
    private int id;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }


    private double latitude;
    private double longitude;


    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double xxx)
    {
        this.latitude = xxx;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double yyy)
    {
        this.longitude = yyy;
    }

    private String summary;
    private String description;
    private int votesAmount;
    private int commentsAmount;
    private int viewsAmount;
    private String source;
    private String tagType;

    private String createdTime;


    public String getSummary()
    {
	return summary;
    }

    public void setSummary(String summary)
    {
	this.summary = summary;
    }

    public String getDescription()
    {
	return description;
    }

    public void setDescription(String description)
    {
	this.description = description;
    }

    public int getVotesAmount()
    {
	return votesAmount;
    }

    public void setVotesAmount(int votesAmount)
    {
	this.votesAmount = votesAmount;
    }

    public int getCommentsAmount()
    {
	return commentsAmount;
    }

    public void setCommentsAmount(int commentsAmount)
    {
	this.commentsAmount = commentsAmount;
    }

    public String getSource()
    {
	return source;
    }

    public void setSource(String source)
    {
	this.source = source;
    }




    public String getTagType()
    {
	return tagType;
    }

    public void setTagType(String tagType)
    {
	this.tagType = tagType;
    }

    public int getViewsAmount()
    {
        return viewsAmount;
    }

    public void setViewsAmount(int viewsAmount)
    {
        this.viewsAmount = viewsAmount;
    }


    public String getCreatedTime()
    {
        return createdTime;
    }

    public void setCreatedTime(String createdTime)
    {
        this.createdTime = createdTime;
    }
}
