package com.itview.testcases.selenium_testng_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCode {

	public static void main(String[] args) {

		//1st parameter is driver information and 2nd is path of .exe file
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\selenium-testng-test\\BrowserDriver\\chromedriver.exe");
		// OR 
		//WebDriverManager.chromedriver().setup();	
		
		WebDriver w = new ChromeDriver();
		w.get("http://altoromutual.com:8080/login.jsp");

	}

}
