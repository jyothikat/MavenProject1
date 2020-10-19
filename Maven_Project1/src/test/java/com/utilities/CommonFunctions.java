package com.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
}
