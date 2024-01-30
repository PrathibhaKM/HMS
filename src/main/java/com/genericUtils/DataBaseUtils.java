package com.genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtils {
	Connection conn;
	public void createConnection() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(IpathConstants.DBURL,IpathConstants.DBUsername,IpathConstants.DBPassword);
		
		}
	public String execute(String query,int column,String expdata) throws SQLException
	
	{
		boolean flag = false;
		String data=null;
		
	ResultSet result = conn.createStatement().executeQuery(query);		
	while(result.next())
	{
		data = result.getString(column);
		if(data.equalsIgnoreCase(expdata))
		{
			flag=true;
			break;
			
		}
	}
	if(flag)
	{
		System.out.println(data+"-->is actual data");
		return expdata;
	}
	
		
		else {
			System.out.println("data not verified");
			return " ";
		}
	}
		
		
	
	public void closedb() throws SQLException
	{
		conn.close();
	}
		
	}
	


