package Patient;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver=new ChromeDriver();
driver.get("https://www.amazon.in/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("samsung mobile");
//Thread.sleep(2000);
List<WebElement> allsugg = driver.findElements(By.xpath("//div[contains(text(),'samsung mobile')]"));
int count=allsugg.size();
System.out.println(count);

for(WebElement sugg:allsugg)
{
	String text = sugg.getText();
	System.out.println(text);
}
driver.quit();
		}

}
