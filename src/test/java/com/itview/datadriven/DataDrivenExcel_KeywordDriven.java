package com.itview.datadriven;

import org.testng.annotations.Test;


import com.itview.pageobject.FixedDeposit_PageObj;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

import org.testng.annotations.AfterTest;

public class DataDrivenExcel_KeywordDriven {

	FixedDeposit_PageObj fd = new FixedDeposit_PageObj();

	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet sht;
	XSSFRow row;
	XSSFCell principleCell, roiCell, tenureCell, frequencyCell, executionResult;
	DataFormatter df;

	@BeforeTest
	public void beforeTest() throws Exception {

		fd.openBrowser(fd.readDataFromPropertiesFile("browser"));
		fd.call_FixedDepoist_PageObj();

		fi = new FileInputStream(".\\TestData\\FDCal.xlsx");
		wb = new XSSFWorkbook(fi);
		sht = wb.getSheetAt(0);

		df = new DataFormatter();

	}

	@Test
	public void dataDrivenTest() throws Exception {

		fd.openApplicationURL(fd.readDataFromPropertiesFile("url_fd"));

		fd.clickEvent(fd.no_Thanks_Window);

		fd.waitForSeconds(2);

		int rowCount = sht.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) // i = rows
		{

			row = sht.getRow(i);

			principleCell = row.getCell(0);
			roiCell = row.getCell(1);
			tenureCell = row.getCell(2);
			frequencyCell = row.getCell(3);
			executionResult = row.createCell(5);

			fd.inputValueEvent(fd.principalTxt, df.formatCellValue(principleCell).toString());
			fd.inputValueEvent(fd.interestTxt, df.formatCellValue(roiCell).toString());
			fd.inputValueEvent(fd.tenureTxt, df.formatCellValue(tenureCell).toString());
			fd.handleDropDownList(fd.tenurePeriodDropDown, "year(s)");
			fd.handleDropDownList(fd.frequencyDropDown, frequencyCell.toString());
			fd.clickEvent(fd.calculateBtn);
			fd.waitForSeconds(3);

			String maturityValue = fd.maturityValue.getText();
			System.out.println("Maturity Value for : " + principleCell + " is = " + maturityValue);

			

			

		}

	}

	@AfterTest
	public void afterTest() throws Exception {

		fd.closeBrowser();
		
		

	}

}
