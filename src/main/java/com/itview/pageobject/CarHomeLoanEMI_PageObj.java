package com.itview.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarHomeLoanEMI_PageObj extends TestBase{
		
	@FindBy(id="carhome_loan")
	public WebElement carhome_loan_textBox;
	
	@FindBy(id="loan_period")
	public WebElement loan_period_textBox;
	
	@FindBy(css="select.custselect")
	public WebElement emi_start_from_DropDown;	
	
	@FindBy(id="interest_rate")
	public WebElement interest_rate_textbox;	
	
	@FindBy(id="upfront_charges")
	public WebElement upfront_charges_textbox;
	
	@FindBy(xpath="/html/body/div[13]/section[1]/div/div/div[1]/div[1]/div/div[2]/div/div[5]/a[1]")
	public WebElement submitBtn;	
	
	
	@FindBy(id="wzrk-cancel")
	public WebElement no_Thanks_Messsage;
	
	@FindBy(id="emi")
	public WebElement emi_Value;
	
	
	
	
	public void call_CarHomeLoanEMI_PageObj() {
		
		PageFactory.initElements(w,this);
	}

}
