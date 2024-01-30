package com.objectRepo3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtils.WebDriverUtils;

public class BookAppointmentPage {
	//declaration
	@FindBy(name="Doctorspecialization")
	private WebElement doctorspecialization;
	
	@FindBy(name="doctor")
	private WebElement doctorname;
	
	@FindBy(name="fees")
	private WebElement consultancyfee;
	
	@FindBy(name="appdate")
	private WebElement date;
	
	@FindBy(name="apptime")
	private WebElement time;
	
	@FindBy(name="submit")
	private WebElement submitbtn;
	
	

	//initialization
	public BookAppointmentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDoctorspecialization() {
		return doctorspecialization;
	}

	public void setDoctorspecialization(WebElement doctorspecialization) {
		this.doctorspecialization = doctorspecialization;
	}

	public WebElement getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(WebElement doctorname) {
		this.doctorname = doctorname;
	}

	public WebElement getConsultancyfee() {
		return consultancyfee;
	}

	public void setConsultancyfee(WebElement consultancyfee) {
		this.consultancyfee = consultancyfee;
	}

	public WebElement getDate() {
		return date;
	}

	public void setDate(WebElement date) {
		this.date = date;
	}

	public WebElement getTime() {
		return time;
	}

	public void setTime(WebElement time) {
		this.time = time;
	}

	public WebElement getSubmit() {
		return submitbtn;
	}

	
	public void clickOnSelectDropdown(WebElement element,String value)
	{
		WebDriverUtils wu=new WebDriverUtils();
		wu.selectDropdown1(element, value);
	}
	
	public void clickOnSelectDropdown1(WebElement element,String text)
	{
		WebDriverUtils wu=new WebDriverUtils();
		wu.selectDropdown3(element, text);
	}
	
		public void clickOnSubmit()
	{
		submitbtn.click();
	}
	
	
	
}
