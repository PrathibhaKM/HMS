package Patient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtils.BaseClass;
@Listeners(com.genericUtils.ListenerImplementation.class)
public class ToTakeScreenShot extends BaseClass{
	@Test
	public void run()
	{
		
		driver.get("https://indeed.com/");
		driver.getTitle();
		
		//Assert.fail();
		driver.quit();
	}

}
