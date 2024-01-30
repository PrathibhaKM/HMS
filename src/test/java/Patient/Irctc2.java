package Patient;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.genericUtils.JavaUtils;
import com.genericUtils.WebDriverUtils;

public class Irctc2 {
	public static void main(String[] args) throws InterruptedException
	{ 
		 ChromeOptions options=new ChromeOptions();
		 options.addArguments("--disable-notifications--");
	WebDriver driver=new ChromeDriver(options);
		 
		 WebDriverUtils wu = new WebDriverUtils();
		 wu.maximizeBrowser(driver);
		 wu.implicitWaitCondition(driver, 20);
		 driver.get("https://www.irctc.co.in/nget/train-search");
		// driver.get("https://www.bus.irctc.co.in/home");
		 wu.waitForPageLoad(driver, 10);
		
		driver.findElement(By.xpath("//a[text()=' BUSES ']")).click();
		
		 
		 Set<String> whs = driver.getWindowHandles();
		  for(String wh:whs) {
		 driver.switchTo().window(wh);
		  }
		  Thread.sleep(4000);
		 driver.findElement(By.xpath("//input[@id='departFrom']")).sendKeys("Benga");
		 driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();
		driver.findElement(By.xpath("//input[@id='goingTo']")).sendKeys("Shimo");
		driver.findElement(By.xpath("//div[text()='Shimoga']")).click();
		driver.findElement(By.xpath("//input[@name='departDate']")).click();
		driver.findElement(By.xpath("//a[text()='26']")).click();
		driver.findElement(By.xpath("//button[text()='Search Bus ']")).click();
		driver.findElement(By.xpath("//h4[text()='Departure Time']/ancestor::div[@class='heading-02-wrap']//label[text()='After 6 pm']")).click();
		driver.findElement(By.xpath("//label[text()='Shekar Travels']/ancestor::div[@class='search-result-card']//button[text()='Select Seat'][1]")).click();
		driver.findElement(By.xpath("//span[@title='Seat No. : L2 | Fare : INR 1258.95']")).click();
		//click onradio button
		driver.findElement(By.xpath("//td[text()=' HSR Layout ']/ancestor::tr/td/input[@type='radio']")).click();
	driver.findElement(By.xpath("//button[text()='Proceed to Book']")).click();
	
	driver.findElement(By.xpath("//a[@id='profile-tab']")).click();
	driver.findElement(By.xpath("//input[@id='emailLogin']")).sendKeys("aksh@gmail.com");
	driver.findElement(By.xpath("//input[@id='phoneLogin']")).sendKeys("7639226799");

	driver.findElement(By.xpath("//input[@name=\"phoneLogin\"]/parent::div/following-sibling::div/button[text()='Login']")).click();
	driver.findElement(By.xpath("//input[@name='mobileno']")).sendKeys("7639226799");
	 WebElement element = driver.findElement(By.xpath("//select[@name='country']"));
	 driver.findElement(By.xpath("//select[@name='country']")).click();
	Select s=new Select(element);
	s.selectByValue("India");
	
			
		  }
		 
		 
	}



