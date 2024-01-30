package Admin;

import org.testng.annotations.Test;

import com.genericUtils.BaseClass;

public class DemoTest extends BaseClass {
	@Test
	public void demoTest()
	{
		driver.get("https://www.amazon.in");
		driver.quit();
	}
}
