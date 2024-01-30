package Patient;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtils.BaseClass;
import com.genericUtils.ExcelUtils;
import com.genericUtils.FileUtils;
import com.genericUtils.JavaUtils;
import com.genericUtils.WebDriverUtils;
import com.objectRepo2.DoctorHomePage;
import com.objectRepo2.DoctorLoginPage;
import com.objectRepo3.BookAppointmentPage;
import com.objectRepo3.MainHomePage;
import com.objectRepo3.PatientRegistrationPage;
import com.objectRepo3.UserLoginPage;
@Listeners(com.genericUtils.ListenerImplementation.class)
public class BookAppointment extends BaseClass {
@Test(groups="regression")
	public void bookAppointment() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		FileUtils fu = new FileUtils();
		ExcelUtils eu = new ExcelUtils();
		JavaUtils ju = new JavaUtils();
		WebDriverUtils wu = new WebDriverUtils();
        UserLoginPage ul=new UserLoginPage(driver);
        MainHomePage mh=new MainHomePage(driver);
		int r = ju.getRandom();
		/*
		 * Random ran=new Random(); int r = ran.nextInt(200);
		 */
		wu.maximizeBrowser(driver);
		String Urlp = fu.readData("urlp");
		String Unp = r+fu.readData("unp");
		System.out.println(Unp);
		String Pwdp = fu.readData("pwdp");
		driver.get(Urlp);

		/*
		 * FileInputStream fis=new
		 * FileInputStream(".\\src\\test\\resources\\Logincredentials.properties.txt");
		 * Properties p=new Properties(); p.load(fis); String Urlp =
		 * p.getProperty("urlp"); String Unp = p.getProperty("unp"); String Pwdp =
		 * p.getProperty("pwdp");
		 */

		String Pname = "Pooja" + r;

		wu.implicitWaitCondition(driver, 10);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wu.waitForPageLoad(driver, 10);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//a[@href='registration.php']")).click();
		PatientRegistrationPage pr = new PatientRegistrationPage(driver);
		pr.addname(Pname);
		// driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(Pname);
		pr.addAddress("Nagavara");
		// driver.findElement(By.xpath("//input[@name='address']")).sendKeys("Nagavara");
		pr.addCity("Bangalore");
		// driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Bangalore");
		pr.clickOnFemaleRadioBtn();
		// driver.findElement(By.xpath("//label[@for='rg-female']")).click();
		pr.addemail(Unp);
		// driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Unp+r);
		pr.addPassword(Pwdp);
		// driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Pwdp);
		pr.addConfirmationPassword(Pwdp);
		// driver.findElement(By.xpath("//input[@name='password_again']")).sendKeys(Pwdp);
		pr.clickOnSubmitBtn();
		Thread.sleep(2000);
//		 driver.findElement(By.name("submit")).click();
		//wu.explicitWaitCondition3(driver);
		Alert a1 = driver.switchTo().alert();
		String text1 = a1.getText();
		if (text1.contains("Successfully Registered"))
		{
			System.out.println("patient registered successfully");
			a1.accept();
		}
		System.out.println(Unp);
		Thread.sleep(5000);
		driver.get(Urlp);
		ul.setLoginbtn(Unp, Pwdp);

		/*driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Unp);
		wu.explicitWaitCondition1(driver, By.xpath("//input[@name='username']"));
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Pwdp);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name='submit']")).click();*/
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()=' Book Appointment ']")).click();
		Thread.sleep(2000);

		BookAppointmentPage ba = new BookAppointmentPage(driver);

		//WebElement ele = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
		ba.clickOnSelectDropdown(driver.findElement(By.xpath("//select[@name='Doctorspecialization']")), "kmn");

		/*
		 * Select s=new Select(ele); s.selectByValue("kmn");
		 */

//select doctor name
		//WebElement ele1 = driver.findElement(By.xpath("//select[@name='doctor']"));
		/*
		 * Select s1=new Select(ele1); s1.selectByVisibleText("Sowmya");
		 */

		ba.clickOnSelectDropdown1(driver.findElement(By.xpath("//select[@name='doctor']")),"Sowmya");
		
		driver.findElement(By.xpath("//input[@name='appdate']")).click();

//driver.findElement(By.xpath("//th[text()='February 2024']/ancestor::div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']/descendant::tbody/tr[2]/td[text()='4']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[text()='23']")).click();
		//ba.clickOnSubmit();
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		
//switch to alert popup
		Alert alert = driver.switchTo().alert();
		String confirmationmsg = "Your appointment successfully booked";
		if (alert.getText().equals(confirmationmsg)) {
			System.out.println("appointment is booked");
		}
		alert.accept();
		
		/*
		 * driver.findElement(By.xpath("//span[@class='username']")).click();
		 * driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		 */
		mh.clickOnLogout();
//login as doctor
		driver.findElement(By.xpath(
				"//h3[text()='Doctors Login']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a[text()='Click Here']"))
				.click();

		String Urld = fu.readData("urld");
		String Und = fu.readData("und");
		String Pwdd = fu.readData("pwdd");
		
		/*
		 * String Urld = p.getProperty("urld"); String Und = p.getProperty("und");
		 * String Pwdd = p.getProperty("pwdd");
		 */
	
		
	/*	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Und);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Pwdd);
		driver.findElement(By.xpath("//button[@name='submit']")).click();*/

		//Thread.sleep(2000);
//verifying patient appointment
		DoctorHomePage dh=new DoctorHomePage(driver);
		DoctorLoginPage dl = new DoctorLoginPage(driver);
		dl.setLogibtn(Und, Pwdd);
		
		  driver.findElement(By.xpath("//span[text()=' Appointment History ']")).click(
		  ); driver.findElement(By.xpath("//span[@class='username']")).click();
		 Thread.sleep(3000);
		 
//		List<WebElement> elements = driver.findElements(By.xpath("//td[@class='hidden-xs']"));
//		for (WebElement i : elements) {
//			String t = i.getText();
//			if (t.equals(Pname)) {
//				System.out.println("Patient got appointement");
//			}
//		}
//		Thread.sleep(2000);
//      dh.clickOnLogout(driver);
		 
		 try{
			 dh.getUsername().click();
			 dh.getLogoutbtn().click();
		 }
		 catch(Exception e) {
				 dh.getUsername().click();
				 dh.getLogoutbtn().click();			 
		 }
		 driver.quit();
	//	driver.findElement(By.xpath("//a[@href='logout.php']")).click();

	}

}
