package com.webrob.spatial.domain;

import lombok.Data;

/**
 * Created by Robert on 2015-01-02.
 */
public @Data class SearchSchoolParameters
{
    private double distance;
    private double latitude;
    private double longitude;
}
