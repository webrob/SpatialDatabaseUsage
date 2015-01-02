package com.webrob.spatial.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Robert on 2014-12-31.
 */
@XmlRootElement
public class AreaStatistics
{


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

    public int getSumVotesAmount()
    {
	return sumVotesAmount;
    }

    public void setSumVotesAmount(int sumVotesAmount)
    {
	this.sumVotesAmount = sumVotesAmount;
    }

    public int getSumCommentsAmount()
    {
	return sumCommentsAmount;
    }

    public void setSumCommentsAmount(int sumCommentsAmount)
    {
	this.sumCommentsAmount = sumCommentsAmount;
    }

    public int getSumViewsAmount()
    {
	return sumViewsAmount;
    }

    public void setSumViewsAmount(int sumViewsAmount)
    {
	this.sumViewsAmount = sumViewsAmount;
    }

    public double getAvgVotesAmount()
    {
	return avgVotesAmount;
    }

    public void setAvgVotesAmount(double avgVotesAmount)
    {
	this.avgVotesAmount = avgVotesAmount;
    }

    public double getAvgCommentsAmount()
    {
	return avgCommentsAmount;
    }

    public void setAvgCommentsAmount(double avgCommentsAmount)
    {
	this.avgCommentsAmount = avgCommentsAmount;
    }

    public double getAvgViewsAmount()
    {
	return avgViewsAmount;
    }

    public void setAvgViewsAmount(double avgViewsAmount)
    {
	this.avgViewsAmount = avgViewsAmount;
    }

    private int pointsAmount;
    private int maxVotesAmount;
    private int maxCommentsAmount;
    private int maxViewsAmount;

    private int sumVotesAmount;
    private int sumCommentsAmount;
    private int sumViewsAmount;

    private double avgVotesAmount;
    private double avgCommentsAmount;
    private double avgViewsAmount;

    public void setPointsAmount(int pointsAmount)
    {
        this.pointsAmount = pointsAmount;
    }

    public int getPointsAmount()
    {
        return pointsAmount;
    }
}
