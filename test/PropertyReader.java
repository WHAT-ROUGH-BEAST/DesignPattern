package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader
{
	private String url;
	public PropertyReader(String url)
	{
		this.url = url;
	}
	
	public Object read(String str)
	{
		Properties properties = new Properties();	
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(url);
		
		try
		{
			properties.load(inputStream);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return properties.get(str);
	}
	
//	public static void main(String[] args)
//	{
//		PropertyReader reader = new PropertyReader("resources/config.properties");
//		System.out.println(reader.read("numberType"));
//	}
}
