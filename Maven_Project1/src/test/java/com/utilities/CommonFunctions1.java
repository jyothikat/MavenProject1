package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions1 extends StaticVariables {

	// Constructor: By default constructor will run first method in a class.
	public CommonFunctions1() {
		File screenshotPath = new File(".\\Screenshots");
		if (screenshotPath.exists()) {
			System.out.println("screenshot folder is exits***************");
		} else {
			screenshotPath.mkdir();
			System.out.println("screenshot folder is NOT available, system has created a Folder ***************");
		}

	}

	/*******************
	 * SendKeys by any locator
	 * 
	 * @throws Exception
	 ****************/
	public void sendKeysByAnyLocator(By locator, String inputData) throws Exception {
		WebElement element = driver.findElement(locator);
		// Element IsDisplayed()
		if (element.isDisplayed()) {
			// Element IsEnabled()
			if (element.isEnabled()) {
				highlightElement(element);
				// Clear
				element.clear();
				element.sendKeys(inputData);
			} else {
				System.out.println("The element is disable state, please check the locator***********");
			}
		} else {
			System.out.println("The element is NOT displayed, please check the locator***********");
		}
	}

	/*******************
	 * CLick by any locator
	 * 
	 * @throws Exception
	 ****************/
	public void clickByAnyLocator(By locator) throws Exception {
		WebElement element = driver.findElement(locator);
		// Element IsDisplayed()
		if (element.isDisplayed()) {
			// Element IsEnabled()
			if (element.isEnabled()) {
				highlightElement(element);
				element.click();
			} else {
				System.out.println("The element is disable state, please check the locator***********");
			}
		} else {
			System.out.println("The element is NOT displayed, please check the locator***********");
		}
	}

	public void clickUsingJavaScript(By locator) throws Exception {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		highlightElement(element);
		executor.executeScript("arguments[0].click();", element);
	}

	/**************** timestamp **************************/
	public String timeStamp() {
		// Date and time in a customized format
		Date sd = new Date();
		SimpleDateFormat cdf = new SimpleDateFormat("MMddyyyy_HHmmss");
		String timestamp = cdf.format(sd);
		return timestamp;
	}

	/*********************
	 * takescreenshotWithTimeStamp
	 * 
	 * @throws Exception
	 **********************/
	public void takescreenshotWithTimeStamp() throws Exception {
		// Date and time in a customized format
		Date sd = new Date();
		SimpleDateFormat cdf = new SimpleDateFormat("MMddyyyy_HHmmss");
		String timestamp = cdf.format(sd);
		// Take screenshot of the page
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcfile, new File(".\\Screenshots\\" + timeStamp() + ".PNG"));
		System.out.println("The screenshot taken successfully*********");
	}

	/*************** Browser drivers *******************/
	public void chromeBrowserLaunch() {
		// Launch chrome Browser
		// system will download the latest Chromedriver version
		WebDriverManager.chromedriver().setup();
//		WebDriverManager.chromedriver().browserVersion("86").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void firefoxBrowserLaunch() {
		// Launch Firefox Browser
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	public void ieBrowserLaunch() {
		// Launch IE Browser
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}

	public void edgeBrowserLaunch() {
		// Launch IE Browser
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	public void operaBrowserLaunch() {
		// Launch Firefox Browser
		WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
		driver.manage().window().maximize();
	}

	/********************* Scroll down/up *******************/
	public void scrollToElement(WebElement element) {
		System.out.println("***ScrollToElement: ***");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6px groove green'", element);
	}

	public void scrollToElementBottom(WebElement element) {
		System.out.println("***ScrollToElementBottom:  ***");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
		System.out.println("***ScrollToElementBottom executed; going to hilight el  ***");
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6px groove green'", element);
		System.out.println("***ScrollToElementBottom executed; hilight el  executed***");
	}

	public void highlightElement(WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6px groove green'", element);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
	}

	public void scrollToXY(int x, int y) {
		System.out.println(
				"***ScrollToXY: Move to default Content explicitly. Otherwise it won't work. 'Call switchToDefaultFrame and don't forget to move to your frame.' ***");
		String script = "window.scrollTo(" + x + "," + y + ");";
		((JavascriptExecutor) driver).executeScript(script);
	}

	public int getXLocationOfElement(WebElement element) {
		System.out.println("***GetXLocationOfElement: Don't forget to move to your frame.***");
		Point point = element.getLocation();
		int x = point.getX();
		System.out.println("X Coordination of the Element: " + x);
		return x;
	}

	public int getYLocationOfElement(WebElement element) {
		System.out.println("***GetYLocationOfElement: Don't forget to move to your frame.***");
		Point point = element.getLocation();
		int y = point.getY();
		System.out.println("Y Coordination of the Element: " + y);
		return y;
	}

	public void scrollToBottom() {
		System.out.println(
				"***ScrollToBottom: Move to default Content explicitly. Otherwise it may not work. 'Call switchToDefaultFrame and don't forget to move to your frame.' ***");

		System.out.println("ScrollToBottom: document.body.scrollHeight: "
				+ ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight;"));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	public void ScrollToTop() {
		System.out.println(
				"***ScrollToTop: Move to default Content explicitly. Otherwise it may not work. 'Call switchToDefaultFrame and don't forget to move to your frame.' ***");

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");
	}

	/**************** Waits in Webdriver *******************/
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void explicitWait(int time, By locator) {
		// Explicit wait
		WebDriverWait ww = new WebDriverWait(driver, time);
		ww.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/******************** Frames Handling *******************/

	public int iframeCount() {
		driver.switchTo().defaultContent();
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		int numberOfFrames = 0;
		numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are: " + numberOfFrames);
		return numberOfFrames;
	}

	public void switchToFrameByInt(int i) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(i);
	}

	public int loopAllFramesAndReturnCountofElement(By locator) {

		int elementpresenceCount = 0;
		int loop = 0;
		int maxFramaecount = iframeCount();// 3
		// if given locater has present on webpage, then the element size would be '1'
		// else '0'
		elementpresenceCount = driver.findElements(locator).size();// 0
		while (elementpresenceCount == 0 && loop < maxFramaecount) {
			try {
				switchToFrameByInt(loop);
				elementpresenceCount = driver.findElements(locator).size();// 1
				System.out.println("Try LoopAllframesAndReturnWebEL : " + loop + "; ElementpresenceCount: "
						+ elementpresenceCount);
				if (elementpresenceCount > 0 || loop > maxFramaecount) {
					break;
				}
			} catch (Exception ex) {
				System.out.println("Catch LoopAllframesAndReturnWebEL Old: " + loop + "; " + ex);
			}
			loop++;
		}
		return elementpresenceCount;
	}

	/****************** Dropdown selection **************************************/

//	WebElement monthEle = driver.findElement(By.xpath("//select[@title='Change the month']"));
//	Select month = new Select(monthEle);
//	month.selectByVisibleText("March");

	public void selectByVisibleText(By locater, String visibleText) {

		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByVisibleText(visibleText);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void selectByIndex(By locater, int index) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByIndex(index);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void selectByValue(By locater, String value) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByValue(value);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void printAllDropdownValues(By locater) {
		WebElement element = driver.findElement(locater);

		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				List<WebElement> dropdownValues = dropdown.getOptions();
				// Print the size of dropdown values
				System.out.println(dropdownValues.size());
				// Print the dropdown values
				for (int i = 0; i < dropdownValues.size(); i++) {
					System.out.println(dropdownValues.get(i).getText());
				}
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void selectCustomiseOptionFromTheDropdownValues(By locater, String visibleText) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {

				Select dropdown = new Select(element);
				List<WebElement> dropdownValues = dropdown.getOptions();
				// Print the size of dropdown values
				System.out.println(dropdownValues.size());
				// Print the dropdown values
				for (int i = 0; i < dropdownValues.size(); i++) {
					System.out.println(dropdownValues.get(i).getText());

					// Select Aug option from the dropdown
					if (dropdownValues.get(i).getText().equals(visibleText)) {
						dropdown.selectByIndex(i);
						break;
					}
				}

			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}
	
		/****Click on tab key on mobile number element**********/
	public void tabmoveOnElement(By locator) {		
		WebElement inputField = driver.findElement(locator);
		inputField.sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

}