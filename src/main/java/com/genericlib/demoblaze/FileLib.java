package com.genericlib.demoblaze;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileLib {
	
	String PropPath="TestData/TestData.properties";
	
	public String getDataFromProperties(String key) throws IOException {
		FileInputStream ip=new FileInputStream(PropPath);
		Properties prop=new Properties();
		prop.load(ip);
		return prop.getProperty(key);
	}
}
