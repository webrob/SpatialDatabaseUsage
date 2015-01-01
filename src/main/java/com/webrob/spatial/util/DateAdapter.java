package com.webrob.spatial.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Robert on 2014-12-29.
 */
public class DateAdapter extends XmlAdapter<String, Date>
{
    // the desired format
    private static String pattern = "dd-MM-yyyy ss:mm:HH";

    public String marshal(Date date) throws Exception
    {
	return new SimpleDateFormat(pattern).format(date);
    }

    public Date unmarshal(String dateString) throws Exception
    {
	return new SimpleDateFormat(pattern).parse(dateString);
    }

    public static Date getDateFromString(String dateString)
    {
	Date date = null;
	try
	{
	    date = new SimpleDateFormat(pattern).parse(dateString);
	}
	catch (ParseException e)
	{
	    e.printStackTrace();
	}
	return date;
    }

}