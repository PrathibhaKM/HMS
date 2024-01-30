package Patient;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericUtils.ExcelUtils;
import com.genericUtils.FileUtils;
import com.genericUtils.IpathConstants;
import com.genericUtils.JavaUtils;
import com.genericUtils.WebDriverUtils;

public class ReadFromExcel {
	//WebDriver driver = new ChromeDriver();
	//FileUtils fu = new FileUtils();
	
	/*JavaUtils ju = new JavaUtils();
	WebDriverUtils wu = new WebDriverUtils();
@DataProvider*/


@DataProvider
public Object[][] getDataFromExcel() throws EncryptedDocumentException, IOException
{ExcelUtils eu = new ExcelUtils();
Object[][] value=eu.readMultipleData("Sheet1");
return value;
	
}

@Test(dataProvider="getDataFromExcel")
public void run(String un,String pwd)
{
	System.out.println(un+"-->"+pwd);
}


}