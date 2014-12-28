package ngdemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Robert on 2014-12-27.
 */
@XmlRootElement
public class Test
{
    private String a;

    public String getA()
    {
	return a;
    }

    public void setA(String a)
    {
	this.a = a;
    }
}
