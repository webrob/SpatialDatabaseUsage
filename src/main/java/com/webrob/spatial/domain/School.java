package com.webrob.spatial.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Robert on 2015-01-02.
 */
@XmlRootElement
public @Data class School
{
    private String lowestClassType;
    private String name;
    private int classesAmount;

}
