package com.objectRepo2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtils.WebDriverUtils;

public class DoctorHomePage {
	@FindBy(xpath="//span[@class='username']/i")
	private WebElement username;

	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	private WebElement logoutbtn;
	
	public DoctorHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getUsername() {
		return username;
	}


	public WebElement getLogoutbtn() {
		return logoutbtn;
	}


	public void clickOnLogout(WebDriver driver) throws InterruptedException
	{
		username.click();
//		webu.explicitWaitCondition2(driver, By.xpath("//a[contains(text(),'Log Out')]"));
		
//		webu.clickOperation(driver, logoutbtn);
	}

}
