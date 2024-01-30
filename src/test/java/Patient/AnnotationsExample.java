package Patient;


import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsExample {
	@BeforeSuite
	public void openConnection()
	{
		Reporter.log("open connection");
	}

	
	@BeforeClass
	public void launchBrowser()
	{
		Reporter.log("launch browser",true );
	}
	@BeforeMethod
	public void login()
	{
		Reporter.log("login to application",true);
	}
	@BeforeClass
	public void launchBrowser1()
	{
		Reporter.log("launch browser",true );
	}
	@BeforeClass
	public void launchBrowser2()
	{
		Reporter.log("launch browser",true );
	}
	@BeforeMethod
	public void login1()
	{
		Reporter.log("login to application",true);
	}
	
	@Test
	public void create()
	{
		Reporter.log("create",true);
	}
	@AfterMethod
	public void logout1()
	{
		Reporter.log("logout from application",true);
	}
	@Test
	public void modify()
	{
		Reporter.log("modified",true);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		Reporter.log("close browser",true);
	}
	@AfterSuite
	public void closeConnection()
	{
		Reporter.log("close connection",true);
	}

	

}
