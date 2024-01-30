package com.genericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	/**
	 * @author hp
	 * @return
	 */
	public int getRandom()
	{
		Random r=new Random();
		int ran = r.nextInt();
		return ran;
	}
	/**
	 * 
	 * @return
	 */

	public String getSystemDate()
	{
		Date dt=new Date();
		String date = dt.toString();
		return date;
	}
	public String getSystemDateInFormat()
	{
	SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
	Date dt=new Date();
	String date = dt.toString();
	String SystemDateInFormat = dateformat.format(date);
	return SystemDateInFormat;
	
	
	}
}
