package com.objectRepo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	@FindBy(xpath="//span[text()=' Doctors ']")
	private WebElement doctordropdownbtn;
	
	@FindBy(xpath="//span[text()=' Doctor Specialization ']")
	private WebElement doctorsepecializationbtn;
	
	@FindBy(xpath="//input[@name='doctorspecilization']")
	private WebElement doctorsepecializationtxt;
	
	public AdminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getDoctordropdownbtn() {
		return doctordropdownbtn;
	}
	
	
	public WebElement getDoctorsepecializationbtntxt() {
		return doctorsepecializationtxt;
	}
	public WebElement getDoctorsepecialization() {
		return doctorsepecializationbtn;
	}
	public void clickOnDoctor()
	{
		doctordropdownbtn.click();
	}
	
	public void clickOnDoctorSpecialization()
	{
		doctorsepecializationbtn.click();
		
	}
	public void sendValue(String val)
	{
		doctorsepecializationtxt.sendKeys(val);
	}
	

}
