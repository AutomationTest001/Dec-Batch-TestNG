package com.itview.testcases.selenium_testng_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCase {

	public static void main(String[] args) {
		
		//interfaceName instance=new implementClass();		
			
		WebDriver w=new ChromeDriver(); // Open Blank Browser -> Chrome
		
		//Step 1 : Open application with url
        
       w.get("http://altoromutual.com:8080/login.jsp");
       
      // Step 2 : Enter username
       
      w.findElement(By.id("uid")).sendKeys("admin");
      
      //Step 3 : Enter Password
      
      w.findElement(By.id("passw")).sendKeys("admin");
      
     // Step 4: Click login
      
      w.findElement(By.name("btnSubmit")).click();
      
      // Step 5: Click Logout
      
      w.findElement(By.linkText("Sign Off")).click();
      
      
      
      //Step 6 : Close 
      
      w.close();
      
      System.out.println("Admin Test Case Passed !!!!");
	     
	}

}
