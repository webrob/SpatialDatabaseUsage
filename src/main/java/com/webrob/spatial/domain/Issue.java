package com.webrob.spatial.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Robert on 2014-12-29.
 */
@XmlRootElement
public @Data class Issue
{
    private int id;
    private double latitude;
    private double longitude;
    private String summary;
    private String description;
    private int votesAmount;
    private int commentsAmount;
    private int viewsAmount;
    private String source;
    private String tagType;
    private String createdTime;

}
