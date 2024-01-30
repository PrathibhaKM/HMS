package com.objectRepo3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedicalHistoryPage {
	//declaration
	@FindBy(xpath="//span[@class='username']")
	private WebElement usericon;
	
	//initialization
	MedicalHistoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsericon() {
		return usericon;
	}
	
	//utilization

	public void setUsericon() {
		usericon.click();
	}
	
	
	
	
}
