package Patient;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericUtils.ExcelUtils;
import com.genericUtils.FileUtils;
import com.genericUtils.JavaUtils;
import com.genericUtils.WebDriverUtils;

public class UtiliseDataProvider {
@Test(dataProviderClass=ReadFromExcel.class,dataProvider="readData")
public void run(String un,String pwd) throws IOException
{
	/*WebDriver driver = new ChromeDriver();
	FileUtils fu = new FileUtils();
	ExcelUtils eu = new ExcelUtils();
	JavaUtils ju = new JavaUtils();
	WebDriverUtils wu = new WebDriverUtils();
	String Url = fu.readData("url");
	driver.get(Url);*/
	
	System.out.println(un+"-->"+pwd);
	
	
}
	
}
