package com.itview.testng;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CrossBrowserCode {

	WebDriver w;

	@Test(priority = 0, description = "Validate on Chrome")
	public void openGooglePageOnChrome() throws Exception {

		w = new ChromeDriver();
		w.get("https://www.google.com/");
		String pageTitle = w.getTitle();
		Assert.assertEquals(pageTitle, "Google");
		Thread.sleep(2000);
		w.close();

	}

	@Test(priority = 1, description = "Validate on firefox")
	public void openGooglePageOnFirefox() throws Exception {

		w = new FirefoxDriver();
		w.get("https://www.google.com/");
		String pageTitle = w.getTitle();
		Assert.assertEquals(pageTitle, "Google");
		Thread.sleep(2000);// 2000 millisec = 2 sec
		w.close();
	}

	@Test(priority = 2, description = "Validate on Edge")
	public void openGooglePageOnEdge() throws InterruptedException {

		w = new EdgeDriver();
		w.get("https://www.google.com/");
		String pageTitle = w.getTitle();
		Assert.assertEquals(pageTitle, "Google");
		Thread.sleep(2000);
		w.close();
	}

}
