package com.webrob.spatial.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 2015-01-01.
 */
@XmlRootElement
public @Data class InitValues
{
    @Setter(AccessLevel.PROTECTED) private List<String> cites = new ArrayList<>();
    @Setter(AccessLevel.PROTECTED) private List<String> sources = new ArrayList<>();
    @Setter(AccessLevel.PROTECTED) private List<String> tagTypes = new ArrayList<>();
    private int votesAmount;
    private int commentsAmount;
    private int viewsAmount;
    private String maxCreatedTime;
    private String minCreatedTime;

    public void addSource(String source)
    {
	sources.add(source);
    }

    public void addCity(String city)
    {
        cites.add(city);
    }

    public void addTagType(String tagType)
    {
        tagTypes.add(tagType);
    }
}
