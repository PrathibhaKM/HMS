package Admin;

import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtils.BaseClass;
import com.genericUtils.ExcelUtils;
import com.genericUtils.FileUtils;
import com.genericUtils.JavaUtils;
import com.genericUtils.WebDriverUtils;
import com.objectRepo1.AdminHomePage;
import com.objectRepo1.AdminLoginPage;
import com.objectRepo2.CreateSpecializationPage;
import com.objectRepo3.MainHomePage;

@Listeners(com.genericUtils.ListenerImplementation.class)
public class CreateSpecializationTest extends BaseClass {
	
	@Test(groups = "smoke")
	public void createSpecialization1Test() throws IOException {

		WebDriver driver = new ChromeDriver();

		//FileUtils fu = new FileUtils();
		//ExcelUtils eu = new ExcelUtils();
		//JavaUtils ju = new JavaUtils();
		//WebDriverUtils wu = new WebDriverUtils();
		

		AdminLoginPage al = new AdminLoginPage(driver);
		CreateSpecializationPage cs = new CreateSpecializationPage(driver);
		MainHomePage mh = new MainHomePage(driver);
		String Url = fu.readData("url");
		String Un = fu.readData("un");
		String Pwd = fu.readData("pwd");
//		wu.implicitWaitCondition(driver, 10);
		driver.get(Url);
		wu.waitForPageLoad(driver, 10);

		al.setLoginbtn(Un, Pwd);
		Assert.assertEquals(false, true);
		AdminHomePage ah = new AdminHomePage(driver);
		ah.clickOnDoctor();

		ah.clickOnDoctorSpecialization();

		ah.sendValue("internalmedicines");

		cs.clickOnSubmit();
//driver.findElement(By.xpath("//button[@name='submit']")).click();

		String confirmmsg = driver
				.findElement(By.xpath(
						"//p[text()='Doctor Specialization added successfully !!								']"))
				.getText();
		System.out.println(confirmmsg);
//		Assert.fail();
		cs.clickOnLogout();

	}

}
