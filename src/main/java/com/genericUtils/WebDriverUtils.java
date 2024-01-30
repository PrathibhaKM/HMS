package com.genericUtils;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;



public class WebDriverUtils {
	/**
	 * This method is to maximize the browser
	 * 
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is to minimize the browser
	 * 
	 * @param driver
	 */
	public void minimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method is to wait until the element is found
	 * 
	 * @param driver
	 */
	public void implicitWaitCondition(WebDriver driver, int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	public WebDriverWait callWebderiverwaitObject(WebDriver driver, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}

	/**
	 * This method is to wait until the element is found
	 * 
	 * @param driver
	 * @param value
	 */
	public void explicitWaitCondition1(WebDriver driver, By value) {
		WebDriverWait w = callWebderiverwaitObject(driver, 10);
		w.until(ExpectedConditions.presenceOfElementLocated(value));

	}

	/**
	 * This method is to wait until the element is found This method is to
	 * 
	 * @param driver
	 * @param value
	 */

	public void explicitWaitCondition2(WebDriver driver, By value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(value));
	}
	
	public void waitforElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is to wait until the element is found
	 * 
	 * @param driver
	 * @param search
	 */
	public void explicitWaitCondition3(WebDriver driver, WebElement search) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) search));
	}
	public void explicitWaitCondition4(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * This method is to wait until the element is found
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver, int sec) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}

	/**
	 * This method is to wait until the element is found
	 * 
	 * @param value
	 * @param i
	 */
	public void selectDropdown(WebElement value, int i) {
		Select s = new Select(value);
		s.selectByIndex(i);
	}

	/**
	 * This method is to click on download and select the element
	 * 
	 * @param value
	 * @param val
	 */

	public void selectDropdown1(WebElement value, String val) {
		Select s = new Select(value);
		s.selectByValue(val);

	}

	public void selectDropdown3( WebElement webelement,String text) {
		Select s = new Select(webelement);
		s.selectByVisibleText(text);

	}

	
	public void selectDropdown(int val, WebElement element) {
		Select s = new Select(element);
		s.deselectByIndex(val);

	}

	public void selectDropdown1(String value, WebElement element) {
		Select s = new Select(element);
		s.deselectByValue(value);

	}

	public void selectDropdown2(WebElement value, String val) {
		Select s = new Select(value);
		s.deselectByVisibleText(val);

	}

	/**
	 * This is to deselect all selected lists
	 * 
	 * @param value
	 */
	public void selectDropdown(WebElement value) {
		Select s = new Select(value);
		s.deselectAll();

	}

	/**
	 * This method is to click on dropdown and select the element
	 * 
	 * @param text
	 * @param value
	 */
	public void selectDropdown(String text, WebElement value) {
		Select s = new Select(value);
		s.selectByVisibleText(text);
	}

	/**
	 * This is to hover on the mouse
	 * 
	 * @param driver
	 * @param ele
	 */
	public void mouseHover(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();

	}
	
	public void clickOperation(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.click(ele).perform();

	}

	/**
	 * This is to right click on mouse
	 * 
	 * @param driver
	 * @param ele
	 */
	public void rightClickonMouse(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.contextClick(ele).perform();
		;
	}

	/**
	 * This is to doubleclick on the mouse
	 * 
	 * @param driver
	 * @param ele
	 */
	public void doubleClickonMouse(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.doubleClick(ele).perform();

	}

	/**
	 * This is to drag the mouse
	 * 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, target);

	}
	public  void getScreenShot(WebDriver driver,String screenshotName) throws IOException
	{JavaUtils ju=new JavaUtils();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
	
		
		String path = ".\\Screenshot\\"+screenshotName+ju.getSystemDate()+".jpg";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		
		
			
			
		}

	/**
	 * This is to release the pressed key
	 * 
	 * @throws AWTException
	 */

	public void enterKeyRelease() throws AWTException {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * This is to switch into frame
	 * 
	 * @param driver
	 * @param name
	 */
	public void switchToFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	/**
	 * This is to switch into frame
	 * 
	 * @param driver
	 * @param ele
	 */
	public void switchToFrame(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}

	/**
	 * 
	 * This is to switch to alert popup and click on ok
	 * 
	 * @param driver
	 */
	public void switchToAlertAndClick(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This is to scroll
	 * 
	 * @param driver
	 */

	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", ",");
	}

	/**
	 * This is to scroll
	 * 
	 * @param driver
	 * @param ele
	 */
	public void scrollACtion(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = ele.getLocation().getY();
		js.executeScript("window.scrollBy(0," + y + ")", ele);
	}
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat();
		Date dt=new Date();
		String systemdateinformat=dateformat.format(dt);
		return systemdateinformat;
		
	}

	

}
