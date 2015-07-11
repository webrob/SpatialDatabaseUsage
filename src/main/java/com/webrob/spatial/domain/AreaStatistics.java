package com.webrob.spatial.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Robert on 2014-12-31.
 */
@XmlRootElement
public @Data class AreaStatistics
{
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
}
