package com.itview.actualtestcases;

import org.testng.annotations.Test;

import com.itview.pageobject.CarHomeLoanEMI_PageObj;

import org.testng.annotations.BeforeTest;

import java.util.Scanner;

import org.testng.annotations.AfterTest;

public class CarHomeLoanEMI_Test {
	
	CarHomeLoanEMI_PageObj carHomeLoan=new CarHomeLoanEMI_PageObj();  
	Scanner sc=new Scanner(System.in);
	
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	  carHomeLoan.openBrowser(carHomeLoan.readDataFromPropertiesFile("browser"));
	  carHomeLoan.call_CarHomeLoanEMI_PageObj();
	  
  }
  
  @Test
  public void carHomeLoanEMI_Test1() throws Exception{
	  
	  carHomeLoan.openApplicationURL(carHomeLoan.readDataFromPropertiesFile("baseURL")+"/emi-calculator.html");	
	  
	  carHomeLoan.waitForSeconds(2);
	  
	  carHomeLoan.clickEvent(carHomeLoan.no_Thanks_Messsage);
	  
	  carHomeLoan.waitForSeconds(2);
	  
	  carHomeLoan.pageScrollDown();
	  
	 // System.out.print("Enter Principle Amount : ");
	 // String principleAmt=sc.nextLine();
	  
	  carHomeLoan.inputValueEvent(carHomeLoan.carhome_loan_textBox, "400000");
	  carHomeLoan.inputValueEvent(carHomeLoan.loan_period_textBox, "10");
	  carHomeLoan.handleDropDownList(carHomeLoan.emi_start_from_DropDown, "At the time of loan disbursement");
	  carHomeLoan.inputValueEvent(carHomeLoan.interest_rate_textbox, "7");
	  carHomeLoan.inputValueEvent(carHomeLoan.upfront_charges_textbox, "1000");
	  carHomeLoan.clickEvent(carHomeLoan.submitBtn);
	  
	  carHomeLoan.waitForSeconds(2);
	  
	  System.out.println("EMI Value is : "+carHomeLoan.emi_Value.getText());
  }

  @AfterTest
  public void afterTest() {
	 carHomeLoan.closeBrowser();
  }

}
