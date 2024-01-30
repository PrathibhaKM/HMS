package com.genericUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.objectRepo1.AdminLoginPage;
import com.objectRepo2.DoctorLoginPage;
import com.objectRepo3.MainHomePage;

public class BaseClass {

	public static WebDriver driver;
	public FileUtils fu = new FileUtils();
	public ExcelUtils eu = new ExcelUtils();
	public JavaUtils ju = new JavaUtils();
	public WebDriverUtils wu = new WebDriverUtils();
	public DataBaseUtils du = new DataBaseUtils();
   public static WebDriver sdriver;

	@BeforeSuite
	public void config_connectDB() throws SQLException {
		du.createConnection();
		System.out.println("--connected to db");
	}

  // @Parameters("browser")
	/*@BeforeClass(alwaysRun = true)
	public void config_launchBrowser() throws IOException {
		
		String browser = fu.readData("browser");
	
    	if(browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		//}
//    	else if(browser.equalsIgnoreCase("firefox"))
//    	{
//    		driver=new FirefoxDriver();
//    	}
//    	else
//    	{
//    		System.out.println("invalid browser");
//    	}
    	 sdriver = driver;
		wu.maximizeBrowser(driver);
		wu.implicitWaitCondition(driver, 10);
		System.out.println("browser launched");
	
    	}
	}
    	*/
	@BeforeClass
	public void openBrowser()
	{
		WebDriver driver=new ChromeDriver();
	}
	
	
	@AfterSuite
	public void conficAs() throws SQLException
	{
		du.closedb();
	}
	
}
