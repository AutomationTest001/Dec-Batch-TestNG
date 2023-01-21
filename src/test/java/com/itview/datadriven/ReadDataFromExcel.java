package com.itview.datadriven;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception{

		DataFormatter df=new DataFormatter();
		
		String projectPath = System.getProperty("user.dir");		
		 String excelFilePath = projectPath+"\\TestData\\FDCal.xlsx";
		 
		// "C:\\Users\\Lenovo\\eclipse-workspace\\selenium-testng-test\\TestData\\FDCal.xlsx"
		 FileInputStream fi=new FileInputStream(excelFilePath);
		 
		 XSSFWorkbook wb=new XSSFWorkbook(fi);
		 
		 XSSFSheet sht=wb.getSheetAt(0);
		 
		 XSSFRow row=sht.getRow(1);
		 
		 XSSFCell cell=row.getCell(2);
		 
		// System.out.println(df.formatCellValue(cell));
		 
		 int rowCount = sht.getLastRowNum();
		 
		 System.out.println(rowCount);
		
	}

}
