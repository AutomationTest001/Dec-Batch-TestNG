package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Assignment_1 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		w = new EdgeDriver();
	}

	@Test(priority = 0, description = "Test Case for home page")
	public void homePage() {

		w.get("http://blazedemo.com/");

		String pageTitle = w.getTitle();
		Assert.assertEquals(pageTitle, "BlazeDemo");

		WebElement fromPort_DropDown = w.findElement(By.name("fromPort"));
		Select fromPort_sel = new Select(fromPort_DropDown);
		fromPort_sel.selectByVisibleText("Boston");

		WebElement toPort_DropDown = w.findElement(By.name("toPort"));
		Select toPort_sel = new Select(toPort_DropDown);
		toPort_sel.selectByVisibleText("London");

		w.findElement(By.xpath("/html/body/div[3]/form/div/input")).click();

	}

	@Test(priority = 1, description = "Test Case for reserve page")
	public void reservePage() {

		WebElement pageLabel = w.findElement(By.xpath("/html/body/div[2]/h3"));

		Assert.assertEquals(pageLabel.getText(), "Flights from Boston to London:");

		w.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[1]/input")).click();
	}

	@Test(priority = 2, description = "Test Case for purshase page")
	public void purshasePage() {

		String pageTitle = w.getTitle();
		Assert.assertEquals(pageTitle, "BlazeDemo Purchase");
		WebElement pageLabel = w.findElement(By.xpath("/html/body/div[2]/h2"));
		Assert.assertEquals(pageLabel.getText(), "Your flight from TLV to SFO has been reserved.");

		w.findElement(By.id("inputName")).clear();
		w.findElement(By.id("inputName")).sendKeys("Jones Pence");
		
		//Step are pending
	}
	
		
	@Test(priority = 3, description = "Test Case for confirmation page")
	public void confirmationPage() {
		
		String pageTitle = w.getTitle();
		Assert.assertEquals(pageTitle, "BlazeDemo Confirmation");
	}


	@AfterTest
	public void afterTest() {
		
		
		w.quit();
	}

}
