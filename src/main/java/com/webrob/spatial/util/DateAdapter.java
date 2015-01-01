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
    private static String newPattern = "yyyy-MM-dd";

    public String marshal(Date date) throws Exception
    {
	return new SimpleDateFormat(newPattern).format(date);
    }

    public Date unmarshal(String dateString) throws Exception
    {
	return new SimpleDateFormat(newPattern).parse(dateString);
    }


    public static String changeFormatDateString(String dateString)
    {
	String newFormatDateString = "";
	try
	{
	    Date date = new SimpleDateFormat(newPattern).parse(dateString);
	    newFormatDateString = new SimpleDateFormat(newPattern).format(date);
	}
	catch (ParseException e)
	{
	    e.printStackTrace();
	}
	return newFormatDateString;
    }

}