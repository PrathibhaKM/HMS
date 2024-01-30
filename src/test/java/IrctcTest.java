import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.genericUtils.WebDriverUtils;


public class IrctcTest {
	public static void main(String[] args) {
		
		ChromeOptions options=new ChromeOptions();
		 options.addArguments("--disable-notifications--");
	WebDriver driver=new ChromeDriver(options);
		 
		 WebDriverUtils wu = new WebDriverUtils();
		 
		 wu.implicitWaitCondition(driver, 20);
		 driver.get("https://www.irctc.co.in/nget/train-search");
		// driver.get("https://www.bus.irctc.co.in/home");
		 wu.waitForPageLoad(driver, 10);
		
		driver.findElement(By.xpath("//a[text()=' BUSES ']")).click();
		
		 
		 Set<String> whs = driver.getWindowHandles();
		  for(String wh:whs) {
		  driver.switchTo().window(wh);
		 }
	}
}
