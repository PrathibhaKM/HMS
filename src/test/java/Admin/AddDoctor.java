package Admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.commons.collections4.iterators.EntrySetMapIterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.genericUtils.BaseClass;
import com.genericUtils.ExcelUtils;
import com.genericUtils.FileUtils;
import com.genericUtils.JavaUtils;
import com.genericUtils.WebDriverUtils;
import com.objectRepo2.DoctorHomePage;
import com.objectRepo2.DoctorLoginPage;

public class AddDoctor 
{
@Test(groups="regression")
	public void addDoctor() throws EncryptedDocumentException, IOException, InterruptedException  {
		WebDriver driver=new ChromeDriver();

		FileUtils fu = new FileUtils();
		ExcelUtils eu = new ExcelUtils();
		JavaUtils ju = new JavaUtils();
		WebDriverUtils wu = new WebDriverUtils();
		DoctorLoginPage dl=new DoctorLoginPage(driver);

	String Url = fu.readData("url");
		String Un = fu.readData("un");
		String Pwd = fu.readData("pwd");
		//FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\Logincredentials.properties.txt");
		Properties p=new Properties();
		//p.load(fis1);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		/*String Urld = p.getProperty("urld");
		String Und = p.getProperty("und");
		String Pwdd = p.getProperty("pwdd");*/
		driver.get(Url);
		dl.setLogibtn(Un, Pwd);
	/*	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Pwd);
		driver.findElement(By.xpath("//button[@name='submit']")).click();*/

driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//span[text()=' Add Doctor']")).click();
int row=eu.getLastRowNum("Sheet1");
/*

FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TextFieldAttValueAndPassValue.xlsx");

Workbook wb = WorkbookFactory.create(fis);

int row = wb.getSheet("Sheet1").getLastRowNum();*/
//creating map to store the key and value
//we are doing this because to get the dynamic value present in excel sheet
HashMap<String, String> hs=new HashMap<String, String>();

for(int i=0;i<=row;i++)
{
	String key = eu.readDataFromExcel("Sheet1", i, 0);
	String value = eu.readDataFromExcel("Sheet1", i, 1);
	
	//String key = wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
	//String value = wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
	
	hs.put(key, value);
	
}


for(Entry<String, String> set:hs.entrySet())
{
	if(set.getKey().equalsIgnoreCase("docemail"))
	{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+ju.getRandom());
	}else
	{
	driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	Thread.sleep(2000);
	}
}
WebElement ele3 = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
wu.selectDropdown1(ele3, "kmn");
/*Select s3=new Select(ele3);
s3.selectByValue("Test");*/
driver.findElement(By.xpath("//button[@name='submit']")).click();
Alert a = driver.switchTo().alert();
if(a.getText().contains("Doctor info added Successfully"))
{
System.out.println("Doctor information added");
a.accept();
	}
DoctorHomePage dh=new DoctorHomePage(driver);
try{
	 dh.getUsername().click();
	 dh.getLogoutbtn().click();
}
catch(Exception e) {
		 dh.getUsername().click();
		 dh.getLogoutbtn().click();			 
}
}
}
