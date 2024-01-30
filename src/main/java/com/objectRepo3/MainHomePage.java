package com.objectRepo3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainHomePage {
@FindBy(xpath="//span[@class='username']")
private WebElement username;

@FindBy(xpath="//a[@href='logout.php']")
private WebElement logoutbtn;

public MainHomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void clickOnLogout()
{
	username.click();
	logoutbtn.click();
}
}
