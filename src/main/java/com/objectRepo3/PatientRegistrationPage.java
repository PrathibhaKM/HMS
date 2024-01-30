package com.objectRepo3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientRegistrationPage {
	@FindBy(name = "full_name")
	private WebElement pname;

	@FindBy(name = "address")
	private WebElement address;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(xpath = "//label[@for='rg-female']")
	private WebElement femaleradiobtn;

	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement maleradiobtn;

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(name = "password_again")
	private WebElement confirmationPassword;
	@FindBy(name = "submit")
	private WebElement submit;

	public PatientRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPname() {
		return pname;
	}

	public void setPname(WebElement pname) {
		this.pname = pname;
	}

	public WebElement getAddress() {
		return address;
	}

	public void setAddress(WebElement address) {
		this.address = address;
	}

	public WebElement getCity() {
		return city;
	}

	public void setCity(WebElement city) {
		this.city = city;
	}

	public WebElement getFemaleradiobtn() {
		return femaleradiobtn;
	}

	public void setFemaleradiobtn(WebElement femaleradiobtn) {
		this.femaleradiobtn = femaleradiobtn;
	}

	public WebElement getMaleradiobtn() {
		return maleradiobtn;
	}

	public void setMaleradiobtn(WebElement maleradiobtn) {
		this.maleradiobtn = maleradiobtn;
	}

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(WebElement email) {
		this.email = email;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getConfirmationPassword() {
		return confirmationPassword;
	}

	public void setConfirmationPassword(WebElement confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}

	public void addname(String name) {
		pname.sendKeys(name);
	}

	public void addemail(String em) {
		email.sendKeys(em);
	}

	public void addAddress(String paddress) {
		address.sendKeys(paddress);
	}

	public void addCity(String pcity) {
		city.sendKeys(pcity);
	}

	public void clickOnFemaleRadioBtn() {
		femaleradiobtn.click();
	}

	public void clickOnMaleRadioBtn() {
		maleradiobtn.click();
	}

	public void addPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void addConfirmationPassword(String pwd) {
		confirmationPassword.sendKeys(pwd);
	}

	public void clickOnSubmitBtn() {
		submit.click();
	}

}
