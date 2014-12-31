package com.webrob.spatial.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Robert on 2014-12-31.
 */
@XmlRootElement
public class SearchAreaStatistics
{
    public double getNortEastLatitude()
    {
	return nortEastLatitude;
    }

    public void setNortEastLatitude(double nortEastLatitude)
    {
	this.nortEastLatitude = nortEastLatitude;
    }

    public double getNortEastLongitude()
    {
	return nortEastLongitude;
    }

    public void setNortEastLongitude(double nortEastLongitude)
    {
	this.nortEastLongitude = nortEastLongitude;
    }

    public double getSouthWestLatitude()
    {
	return southWestLatitude;
    }

    public void setSouthWestLatitude(double southWestLatitude)
    {
	this.southWestLatitude = southWestLatitude;
    }

    public double getSouthWestLongitude()
    {
	return southWestLongitude;
    }

    public void setSouthWestLongitude(double southWestLongitude)
    {
	this.southWestLongitude = southWestLongitude;
    }

    private double nortEastLatitude;
    private double nortEastLongitude;
    private double southWestLatitude;
    private double southWestLongitude;
}
