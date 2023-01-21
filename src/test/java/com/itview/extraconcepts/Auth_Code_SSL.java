package com.itview.extraconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Auth_Code_SSL {

	public static void main(String[] args) throws Exception{

		String username="admin";
		String password="admin";
		
		//SSL -> https://expired.badssl.com/
		//ChromeOptions options=new ChromeOptions();
		//options.setAcceptInsecureCerts(true);

		WebDriver w=new ChromeDriver();
		w.get("https://expired.badssl.com/");

		//AUTH -> https://the-internet.herokuapp.com/basic_auth
		
		//https://username:password@URL
		//w.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		

	}

}
