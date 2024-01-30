package Doctor;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericUtils.ExcelUtils;
import com.genericUtils.FileUtils;
import com.genericUtils.JavaUtils;
import com.genericUtils.WebDriverUtils;

public class Update_Doctor_Details {
@Test(groups="smoke")
	public void updateDoctor() throws IOException, InterruptedException {

		FileUtils fu = new FileUtils();
		ExcelUtils eu = new ExcelUtils();
		JavaUtils ju = new JavaUtils();
		WebDriverUtils wu = new WebDriverUtils();

		String Urld = fu.readData("urld");
		String Und = fu.readData("und");
		String Pwdd = fu.readData("pwdd");
		/*
		 * FileInputStream fis=new
		 * FileInputStream(".\\src\\test\\resources\\LoginCredential.properties");
		 * Properties p=new Properties(); p.load(fis); String Urld =
		 * p.getProperty("urld"); String Und = p.getProperty("und"); String Pwdd =
		 * p.getProperty("pwdd");
		 */
		WebDriver driver = new ChromeDriver();

		driver.get(Urld);
		wu.waitForPageLoad(driver, 10);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		wu.implicitWaitCondition(driver, 10);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Und);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Pwdd);
		driver.findElement(By.xpath("//button[@name='submit']")).click();

//click on appointment history
		driver.findElement(By.xpath("//span[text()=' Appointment History ']")).click();
		Thread.sleep(2000);
//click on patient dropdown
		driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
//click on add patient
		driver.findElement(By.xpath("//span[text()=' Add Patient']")).click();

//		int row1 = eu.getLastRowNum("Sheet2");
	

		/*
		 * FileInputStream fis1=new
		 * FileInputStream(".\\src\\test\\resources\\TextFieldAttValueAndPassValue.xlsx"
		 * );
		 * 
		 * Workbook wb1 = WorkbookFactory.create(fis1);
		 * 
		 * int row1 = wb1.getSheet("Sheet2").getLastRowNum();
		 */
//creating map to store the key and value
//we are doing this because to get the dynamic value present in excel sheet
		HashMap<String, String> hs = eu.hashMapData("Sheet2", 0);
		/*
		 * HashMap<String, String> hs=new HashMap<String, String>();
		 * 
		 * for(int i=0;i<=row1;i++) { String key =
		 * wb1.getSheet("Sheet2").getRow(i).getCell(0).getStringCellValue(); String
		 * value = wb1.getSheet("Sheet2").getRow(i).getCell(1).getStringCellValue();
		 * Thread.sleep(2000); hs.put(key, value); //System.out.println(hs.get(key)); }
		 */

		Thread.sleep(2000);

		for (Entry<String, String> set : hs.entrySet()) {
			if(set.getKey().equalsIgnoreCase("patemail"))
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+ju.getRandom());
			}else {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			Thread.sleep(2000);}
		}
		
		driver.findElement(By.xpath("//label[@for='rg-female']")).click();
		wu.explicitWaitCondition1(driver, By.xpath("//label[@for='rg-female']"));
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		wu.explicitWaitCondition1(driver, By.xpath("//button[@name='submit']"));
//click on search button
		driver.findElement(By.xpath("//span[text()=' Search ']")).click();
		wu.explicitWaitCondition1(driver, By.xpath("//span[text()=' Search ']"));
		driver.findElement(By.xpath("//span[text()=' Search ']")).click();
		String Patientname = eu.readDataFromExcel("Sheet2", 0, 1);
//String Patientname = wb1.getSheet("Sheet2").getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='searchdata']")).sendKeys(Patientname);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

//click on logout
		driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	}

}
