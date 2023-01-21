package com.itview.testng;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args)throws Exception {
		
	
		
		 String projectPath = System.getProperty("user.dir");		
		 String ConfigPath= projectPath+"\\Config\\config.properties";
		 
		 FileInputStream fi=new FileInputStream(ConfigPath);	
		 
		 
		 Properties p=new Properties();
		 p.load(fi);
		 
		 String url_Value=p.getProperty("baseURL");
		 String browser_Value=p.getProperty("browser");
		 
		 System.out.println(url_Value);
		 System.out.println(browser_Value);
		 
		 fi.close();

	}

}
