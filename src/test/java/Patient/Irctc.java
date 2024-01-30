package Patient;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.genericUtils.DataBaseUtils;
import com.genericUtils.ExcelUtils;
import com.genericUtils.FileUtils;
import com.genericUtils.JavaUtils;
import com.genericUtils.WebDriverUtils;

public class Irctc {
	@Test
	public void irctcAuto() throws InterruptedException
	{ 
		WebDriver driver=new ChromeDriver();
		FileUtils fu = new FileUtils();
		ExcelUtils eu = new ExcelUtils();
		 JavaUtils ju = new JavaUtils();
		 WebDriverUtils wu = new WebDriverUtils();
		 DataBaseUtils du = new DataBaseUtils();
		 wu.implicitWaitCondition(driver, 10);
		 driver.get("https://www.bus.irctc.co.in/home");
		 wu.waitForPageLoad(driver, 10);
		 driver.findElement(By.xpath("//input[@placeholder='Depart From']")).sendKeys("Bengaluru");
		 Actions a=new Actions(driver);
		WebElement dept = driver.findElement(By.xpath("//div[text()='Bengaluru']"));
		a.moveToElement(dept).perform();
		//wu.selectDropdown3(dept,"Bengaluru");
		 //Thread.sleep(2000);
		// driver.findElement(By.xpath("//input[@placeholder='Going To']")).sendKeys("Shivamogga");
		 //Thread.sleep(2000);
		 //driver.findElement(By.xpath("//input[@placeholder='Departure Date']")).click();
		 //driver.findElement(By.xpath("//a[text()='26']")).click();
		//click on search
		driver.findElement(By.xpath("//button[text()='Search Bus ']")).click();
	}

}
