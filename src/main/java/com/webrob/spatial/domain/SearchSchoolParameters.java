package com.webrob.spatial.domain;

/**
 * Created by Robert on 2015-01-02.
 */
public class SearchSchoolParameters
{
    public double getDistance()
    {
	return distance;
    }

    public void setDistance(double distance)
    {
	this.distance = distance;
    }

    private double distance;
    private double latitude;

    public double getLongitude()
    {
	return longitude;
    }

    public void setLongitude(double longitude)
    {
	this.longitude = longitude;
    }

    public double getLatitude()
    {
	return latitude;
    }

    public void setLatitude(double latitude)
    {
	this.latitude = latitude;
    }

    private double longitude;
}
