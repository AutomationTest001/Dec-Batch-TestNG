package com.itview.extraconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Notification {

	public static void main(String[] args) throws Exception{

		//ChromeOptions opt = new ChromeOptions();
		//opt.addArguments("--disable-notifications");
		
		//WebDriver w=new ChromeDriver(opt);
		
		
		WebDriver w = new ChromeDriver();
		//w.get("https://www.justdial.com/Bangalore/Bakeries");
		w.navigate().to("https://www.justdial.com/Bangalore/Bakeries");

		
		

	}

}
