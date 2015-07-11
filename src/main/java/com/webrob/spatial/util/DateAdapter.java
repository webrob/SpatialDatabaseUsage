package com.webrob.spatial.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Robert on 2014-12-29.
 */
public class DateAdapter extends XmlAdapter<String, Date>
{
    private static String newPattern = "yyyy-MM-dd";

    public String marshal(Date date) throws Exception
    {
	return new SimpleDateFormat(newPattern).format(date);
    }

    public Date unmarshal(String dateString) throws Exception
    {
	return new SimpleDateFormat(newPattern).parse(dateString);
    }
}