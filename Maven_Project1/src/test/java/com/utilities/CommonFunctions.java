package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions extends StaticVariables {

	public void sendKeysByAnyLocator(By locator, String inputData) {

		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				highlightElement(element);
				element.clear();
				element.sendKeys(inputData);
			} else {
				System.out.println("The element is not enabled, please check the locator");
			}
		} else {
			System.out.println("The element is not displayed, please check the locator");
		}
	}

	public void clickByAnyLocator(By locator) {

		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				highlightElement(element);
				element.click();
			} else {
				System.out.println("The element is not enabled, please check the locator");
			}
		} else {
			System.out.println("The element is not displayed, please check the locator");
		}
	}

	public void clickByAnyLocatorJavascript(By locator) {
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}
		}

	}
	
	public void scrollToElement(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void highlightElement(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='4px solid green';", element);
	}
	
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	
	public void chromeBrowserLaunch() {

		WebDriverManager.chromedriver().setup();
//		WebDriverManager.chromedriver().browserVersion("86");
		driver = new ChromeDriver();

	}

	public void firefoxBrowserLaunch() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

	}

	public void ieBrowserLaunch() {

		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();

	}
	
	/***************************Timestamp*****************************/
	public void timeStamp() {
		Date sd = new Date();
		SimpleDateFormat cdf = new SimpleDateFormat("MMddyyyy_HHmmss");
		String timestamp = cdf.format(sd);
	}
	
	/*************************Takescreenshotwithtimestamp
	 * @throws IOException *************************/
	
	public void takescreenshotWithTimestamp() throws IOException {
		
		Date sd = new Date();
		SimpleDateFormat cdf = new SimpleDateFormat("MMddyyyy_HHmmss");
		String timestamp = cdf.format(sd);

		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcfile, new File(".\\Screenshots\\" + timestamp + ".jpg"));
	}
}
