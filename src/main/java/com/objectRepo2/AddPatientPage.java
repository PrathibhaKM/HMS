package com.objectRepo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtils.WebDriverUtils;

public class AddPatientPage extends WebDriverUtils{
	@FindBy(xpath="//span[text()=' Dashboard ']")
	private WebElement docdashboard;
	
	@FindBy(xpath="//span[text()=' Appointment History ']")
	private WebElement appointmenthistory;
	
	@FindBy(xpath="//span[text()=' Patients ']")
	private WebElement patients;
	
	@FindBy(xpath="//span[text()=' Search ']")
	private WebElement search;
	
	
@FindBy(name="patname")
private WebElement patientname;

@FindBy(name="patcontact")
private WebElement patientcontact;

@FindBy(name="patemail")
private WebElement patientemail;

@FindBy(xpath="//label[@for='rg-female']")
private WebElement femaleradiobtn;

@FindBy(xpath="//label[@for='rg-male']")
private WebElement maleradiobtn;

@FindBy(name="pataddress")
private WebElement patientaddress;

@FindBy(name="patage")
private WebElement patientage;

@FindBy(name="medhis")
private WebElement patientmedicalhistory;

@FindBy(name="submit")
private WebElement addbtn;

@FindBy(xpath="//span[@class='username']")
private WebElement doctoricon;

//initialization
public void AddPatient(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getDocdashboard() {
	return docdashboard;
}

public WebElement getAppointmenthistory() {
	return appointmenthistory;
}

public WebElement getPatients() {
	return patients;
}

public WebElement getSearch() {
	return search;
}

public WebElement getPatientname() {
	return patientname;
}

public WebElement getPatientcontact() {
	return patientcontact;
}

public WebElement getPatientemail() {
	return patientemail;
}

public WebElement getFemaleradiobtn() {
	return femaleradiobtn;
}

public WebElement getMaleradiobtn() {
	return maleradiobtn;
}

public WebElement getPatientaddress() {
	return patientaddress;
}

public WebElement getPatientage() {
	return patientage;
}

public WebElement getPatientmedicalhistory() {
	return patientmedicalhistory;
}

public WebElement getAddbtn() {
	return addbtn;
}

public WebElement getDoctoricon() {
	return doctoricon;
}

public void setDocdashboard(WebElement docdashboard) {
	this.docdashboard = docdashboard;
}

public void setAppointmenthistory(WebElement appointmenthistory) {
	this.appointmenthistory = appointmenthistory;
}

public void setPatients(WebElement patients) {
	this.patients = patients;
}

public void setSearch(WebElement search) {
	this.search = search;
}

public void setPatientname(WebElement patientname) {
	this.patientname = patientname;
}

public void setPatientcontact(WebElement patientcontact) {
	this.patientcontact = patientcontact;
}

public void setPatientemail(WebElement patientemail) {
	this.patientemail = patientemail;
}

public void setFemaleradiobtn(WebElement femaleradiobtn) {
	this.femaleradiobtn = femaleradiobtn;
}

public void setMaleradiobtn(WebElement maleradiobtn) {
	this.maleradiobtn = maleradiobtn;
}

public void setPatientaddress(WebElement patientaddress) {
	this.patientaddress = patientaddress;
}

public void setPatientage(WebElement patientage) {
	this.patientage = patientage;
}

public void setPatientmedicalhistory(WebElement patientmedicalhistory) {
	this.patientmedicalhistory = patientmedicalhistory;
}

public void setAddbtn(WebElement addbtn) {
	this.addbtn = addbtn;
}

public void setDoctoricon(WebElement doctoricon) {
	this.doctoricon = doctoricon;
}

//business logic
public void addPatient(String name)
{
	patientname.sendKeys(name);
 }
public void addPatientContactnum(String number)
{
	patientcontact.sendKeys(number);
}
public void addPatientEmail(String email)
{
	patientcontact.sendKeys(email);
}
public void clickOnFemaleRadioButton()
{
	femaleradiobtn.click();
}

public void clickOnMaleRadioButton()
{
	maleradiobtn.click();
}

public void addPatientAddress(String address)
{
	patientaddress.sendKeys(address);
}
public void addPatientAge(String age)
{
patientage.sendKeys(age);
}

public void addMedicalHistory(String medicalhistory)
{
	patientmedicalhistory.sendKeys(medicalhistory);
}

public void clickOnAddBtn()
{
	addbtn.click();
}
}
