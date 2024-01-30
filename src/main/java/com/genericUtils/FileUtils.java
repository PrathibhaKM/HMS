package com.genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readData(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.FilePath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
		
	}

}
