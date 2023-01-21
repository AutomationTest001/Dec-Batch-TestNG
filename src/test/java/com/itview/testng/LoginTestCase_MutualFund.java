package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginTestCase_MutualFund {
	
	WebDriver w;
  
  @BeforeTest
  public void preCondition_MutualFund() {
	  
	  w=new ChromeDriver();
  }
  
  @Test(priority = 0,description = "Test Case to verify login using 'Admin' user",groups="LoginModule")
  public void loginAdminTest() {  
	     
     w.get("http://altoromutual.com:8080/login.jsp");
     w.findElement(By.id("uid")).sendKeys("admin");
     w.findElement(By.id("passw")).sendKeys("admin");
     w.findElement(By.name("btnSubmit")).click();
     w.findElement(By.linkText("Sign Off")).click();
    
  //  Assert.fail(); // forcelly fail any test case
  }
  
  @Test(priority = 1,description = "Test Case to verify login using 'TestUser' user",dependsOnMethods="loginAdminTest",groups="LoginModule",invocationCount = 3,enabled=true)
  public void loginTuserTest() {  
	     
     w.get("http://altoromutual.com:8080/login.jsp");
     w.findElement(By.id("uid")).sendKeys("tuser");
     w.findElement(By.id("passw")).sendKeys("tuser");
     w.findElement(By.name("Submit")).click();
     w.findElement(By.linkText("Sign Off")).click();
    
    
  }
  
  
  @Test(priority = 2,description = "Test Case to verify login using 'Invalid' user",dependsOnMethods="loginAdminTest",groups="LoginModule")
  public void loginInvalidUser() {  
	     
     w.get("http://altoromutual.com:8080/login.jsp");
     w.findElement(By.id("uid")).sendKeys("invalid");
     w.findElement(By.id("passw")).sendKeys("tuser");
     w.findElement(By.name("btnSubmit")).click();
    
    
    
  }
  

  @AfterTest
  public void postCondition_MutualFund() {
	 w.close();
  }
  

}
