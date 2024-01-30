package com.objectRepo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage {
	@FindBy(name="username")
	private WebElement doctoruntxt;
	
	@FindBy(name="password")
	private WebElement doctorpwdtxt;
	
	@FindBy(name="submit")
	private WebElement loginbtn;
	
	//initialization
	public DoctorLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	//utilization

	public WebElement getDoctoruntxt() {
		return doctoruntxt;
	}

	public void setDoctoruntxt(WebElement doctoruntxt) {
		this.doctoruntxt = doctoruntxt;
	}

	public WebElement getDoctorpwdtxt() {
		return doctorpwdtxt;
	}

	public void setDoctorpwdtxt(WebElement doctorpwdtxt) {
		this.doctorpwdtxt = doctorpwdtxt;
	}

	public WebElement getLogibtn() {
		return loginbtn;
	}

	public void setLogibtn(String und,String pwd) {
		doctoruntxt.sendKeys(und);
		doctorpwdtxt.sendKeys(pwd);
		loginbtn.click();
	
	}
	
	
}
