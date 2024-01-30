package com.objectRepo3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	// declaration
	@FindBy(css = "[name='username']")
	private WebElement pUsername;
	@FindBy(name = "password")
	private WebElement patientpwdtxt;
	@FindBy(name = "submit")
	private WebElement loginbtn;

	// initialization
	public UserLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// utilization
	public WebElement getPatientuntxt() {
		return pUsername;
	}

	public WebElement getPatientpwdtxt() {
		return patientpwdtxt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getUsericon() {
		return getUsericon();
	}

	public void setLoginbtn(String un, String pwd) throws InterruptedException {
		pUsername.sendKeys(un);
		Thread.sleep(2000);
		patientpwdtxt.sendKeys(pwd);
		loginbtn.click();
	}

}
