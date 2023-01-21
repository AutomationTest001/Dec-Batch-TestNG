package com.itview.datadriven;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DataDriven_FixedDeposit {
  

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "100000", "5.5", "7" ,"Simple Interest" },
      new Object[] { "400000", "6", "4" ,"Simple Interest" },
      new Object[] { "700000", "8", "5" ,"Simple Interest" },
    };
  }
  
  WebDriver w;
  
  @BeforeTest
  public void beforeTest() {
	  
	  w=new ChromeDriver();
	  w.manage().window().maximize();
  }
  
  @Test(dataProvider = "dp")
  public void f(String principle,String ROI, String tenure,String frequencyValue) throws Exception {
	  
	  w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

	  try {
		w.findElement(By.id("wzrk-cancel")).click();
	  }catch(Exception e) {}
	  
	  w.findElement(By.id("principal")).clear();
		w.findElement(By.id("principal")).sendKeys(principle);

		w.findElement(By.name("interest")).clear();
		w.findElement(By.id("interest")).sendKeys(ROI);

		w.findElement(By.id("tenure")).clear();
		w.findElement(By.id("tenure")).sendKeys(tenure);

		WebElement tenurePeriod = w.findElement(By.id("tenurePeriod"));
		Select sel_tenurePeriod = new Select(tenurePeriod);
		sel_tenurePeriod.selectByVisibleText("year(s)");

		Thread.sleep(2000);
		
		WebElement frequency = w.findElement(By.id("frequency"));
		Select sel_frequency = new Select(frequency);
		sel_frequency.selectByVisibleText(frequencyValue);

		w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();

		Thread.sleep(2000);

		String maturityValue = w.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();

		System.out.println("Maturity Value is : " + maturityValue );
		
  }

  @AfterTest
  public void afterTest() {
	  
	  w.quit();
  }

}
