package com.objectRepo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateSpecializationPage {
@FindBy(name="doctorspecilization")
private WebElement doctorspecialization;

@FindBy(name="submit")
private WebElement submitbtn;

@FindBy(xpath="//span[@class='username']")
private WebElement username;

@FindBy(xpath="//a[@href='logout.php']")
private WebElement logoutbtn;

public CreateSpecializationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getDoctorspecialization() {
	return doctorspecialization;
}

public WebElement getSubmitbtn() {
	return submitbtn;
}
public void clickOnSpecialization()
{
	doctorspecialization.click();
}
public void clickOnLogout()
{
	username.click();
	logoutbtn.click();


}
public void clickOnSubmit()
{
	
	submitbtn.click();
}
}
