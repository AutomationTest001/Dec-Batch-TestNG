package com.itview.datadriven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DataDrivenTest {

	String projectPath = System.getProperty("user.dir");
	String excelFilePath = projectPath + "\\TestData\\FDCal.xlsx";

	WebDriver w;

	DataFormatter df;
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet sht;
	XSSFRow row;
	XSSFCell principleCell, roiCell, periodCell, frequencyCell,matValue;

	@BeforeTest
	public void beforeTest() throws Exception {
		w = new ChromeDriver();
		w.manage().window().maximize();

		df = new DataFormatter();
		fi = new FileInputStream(excelFilePath);
		wb=new XSSFWorkbook(fi);
		sht=wb.getSheetAt(0);
		

	}

	@Test
	public void f() throws Exception {

		w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		w.findElement(By.id("wzrk-cancel")).click();
		
		int rowCount = sht.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++) {
			
			row=sht.getRow(i); // i -> represent rows
			
			principleCell=row.getCell(0);
			roiCell=row.getCell(1);
			periodCell=row.getCell(2);
			frequencyCell=row.getCell(3);
			matValue=row.getCell(4);
			

		w.findElement(By.id("principal")).clear();
		w.findElement(By.id("principal")).sendKeys(df.formatCellValue(principleCell).toString());

		w.findElement(By.name("interest")).clear();
		w.findElement(By.id("interest")).sendKeys(df.formatCellValue(roiCell).toString());

		w.findElement(By.id("tenure")).clear();
		w.findElement(By.id("tenure")).sendKeys(df.formatCellValue(periodCell).toString());

		WebElement tenurePeriod = w.findElement(By.id("tenurePeriod"));
		Select sel_tenurePeriod = new Select(tenurePeriod);
		sel_tenurePeriod.selectByVisibleText("year(s)");

		Thread.sleep(2000);
		
		WebElement frequency = w.findElement(By.id("frequency"));
		Select sel_frequency = new Select(frequency);
		sel_frequency.selectByVisibleText(df.formatCellValue(frequencyCell).toString());

		w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();

		Thread.sleep(2000);

		String maturityValue = w.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
		
		String maturityValueExpected=maturityValue.replace(".00", "");		
		

		System.out.println("Maturity Value for : "+df.formatCellValue(principleCell).toString()+ " is " + maturityValue +" | Maturity Value from excel : "+df.formatCellValue(matValue));
		
		Assert.assertEquals(maturityValueExpected, df.formatCellValue(matValue).toString());
		
		//Assert.assertTrue(maturityValue.contains(df.formatCellValue(matValue).toString()));
		
		}

	}

	@AfterTest
	public void afterTest() {
		
		w.quit();
	}

}
