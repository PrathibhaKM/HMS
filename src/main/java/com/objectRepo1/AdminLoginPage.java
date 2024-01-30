package com.objectRepo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	//declaration
	@FindBy(name="username")
	private WebElement adminuntxt;
	
	@FindBy(name="password")
	private WebElement adminpwdtxt;
	
	@FindBy(name="submit")
	private WebElement logibtn;
	
	//initialization
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//utilization
	public WebElement getAdminuntxt() {
		return adminuntxt;
	}

	public void setAdminuntxt(WebElement adminuntxt) {
		this.adminuntxt = adminuntxt;
	}

	public WebElement getAdminpwdtxt() {
		return adminpwdtxt;
	}

	public void setAdminpwdtxt(WebElement adminpwdtxt) {
		this.adminpwdtxt = adminpwdtxt;
	}

	public WebElement getLogibtn() {
		return logibtn;
	}

	public void setLoginbtn(String un,String pwd) {
		adminuntxt.sendKeys(un);
		adminpwdtxt.sendKeys(pwd);
		logibtn.click();

	}


	
	
}
