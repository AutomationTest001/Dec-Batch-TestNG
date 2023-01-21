package com.itview.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitConcepts {

	public static void main(String[] args) throws Exception {

		WebDriver w = new ChromeDriver();
		
	//	w.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		w.get("https://in.via.com/flight-tickets");

		w.findElement(By.id("wzrk-cancel")).click(); // 30 sec

		// Select source location
		w.findElement(By.id("source")).sendKeys("Mumbai"); // 30 sec
       
		Thread.sleep(2000);
		
		w.findElement(By.id("ui-id-1")).click(); // 30 sec

		// Select target location

		w.findElement(By.id("destination")).sendKeys("Pune"); // 30 sec
		
		Thread.sleep(2000);

		w.findElement(By.id("ui-id-2")).click();
		
		Thread.sleep(2000);

		w.findElement(By.xpath("//*[@id='depart-cal']/div[3]/div[2]/div[6]/div[7]")).click();

		Thread.sleep(2000);
		
		w.findElement(By.id("search-flight-btn")).click();
		
	 //Thread.sleep(10000);
		
		//WebDriverWait wt=new WebDriverWait(w,Duration.ofSeconds(30)); // Time
		//wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]")));//Condition
		
		Wait<WebDriver> fluentwt = new FluentWait<WebDriver>(w)
				.withTimeout(Duration.ofSeconds(30)) // Time
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class); // this defines the exception to ignore

		fluentwt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]")));//Condition

		
		
		WebElement getLowestFlightPrice = w
				.findElement(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]"));
		String lowestFlightPrice = getLowestFlightPrice.getText();

		System.out.println("Cheapest Flights is : " + lowestFlightPrice);

		w.close();
	}

}
