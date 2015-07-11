package com.webrob.spatial.domain;

import javafx.geometry.Point2D;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 2014-12-31.
 */
@XmlRootElement
public @Data class SearchAreaStatistics
{
    private double northEastLatitude;
    private double northEastLongitude;
    private double southWestLatitude;
    private double southWestLongitude;

    public List<Point2D> getAllPoints()
    {
        Point2D p1 = new Point2D(southWestLatitude, southWestLongitude);
        Point2D p2 = new Point2D(southWestLatitude, northEastLongitude);
        Point2D p3 = new Point2D(northEastLatitude, northEastLongitude);
        Point2D p4 = new Point2D(northEastLatitude, southWestLongitude);

        List<Point2D> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        points.add(p1);

        return points;
    }

}
