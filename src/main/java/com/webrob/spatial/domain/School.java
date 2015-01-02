package com.webrob.spatial.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Robert on 2015-01-02.
 */
@XmlRootElement
public class School
{
    private String lowestClassType;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private String name;

    public int getClassesAmount()
    {
	return classesAmount;
    }

    public void setClassesAmount(int classesAmount)
    {
	this.classesAmount = classesAmount;
    }

    public String getLowestClassType()
    {
	return lowestClassType;
    }

    public void setLowestClassType(String lowestClassType)
    {
	this.lowestClassType = lowestClassType;
    }

    private int classesAmount;

}
