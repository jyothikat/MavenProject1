package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions extends StaticVariables {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public CommonFunctions() {
		File screenshotpath = new File(".\\Screenshots\\");
		if (screenshotpath.exists()) {
			System.out.println("Screenshots folder exists");
		} else {
			screenshotpath.mkdir();
			System.out.println("Screenshots folder is not available, system has created the folder");
		}
	}

	/******************** SendKeys by any locator ********************/

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

	/********************** Click by any locator *******************/

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
				highlightElement(element);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}
		}

	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public void highlightElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='4px solid green';", element);
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	/************************************
	 * Launch browser
	 ****************************/

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
	
	
	/*************************** Timestamp *****************************/
	public String timeStamp() {
		Date sd = new Date();
		SimpleDateFormat cdf = new SimpleDateFormat("MMddyyyy_HHmmss");
		String timestamp = cdf.format(sd);
		return timestamp;
	}

	/********** Takescreenshotwithtimestamp ****************************/

	public void takescreenshotWithTimestamp(String name) throws IOException {

		Date sd = new Date();
		SimpleDateFormat cdf = new SimpleDateFormat("MMddyyyy_HHmmss");
		String timestamp = cdf.format(sd);
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcfile, new File(".\\Screenshots\\" + name + timestamp + ".jpg"));
	}
	
	/*****************************Dropdown selection********************************/

	public void selectByVisibleText(By locator, String visibleText) {

		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByVisibleText(visibleText);
			} else {
				System.out.println("The element is not enabled, please check the locator");
			}
		} else {
			System.out.println("The element is not displayed, please check the locator");
		}
	}
	
	
	public void selectByIndex(By locator, int index) {
		WebElement element = driver.findElement(locator);
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

	public void selectByValue(By locator, String value) {
		WebElement element = driver.findElement(locator);
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
	
	public void printAllDropdownValues(By locator) {
		WebElement element = driver.findElement(locator);

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

	public void selectCustomiseOptionFromTheDropdownValues(By locator, String visibleText) {
		WebElement element = driver.findElement(locator);
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
						dropdown.selectByVisibleText(visibleText);
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


	/************************* Handling iFrames ********************************/

	public int iFrameCount() {
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
		int maxFramecount = iFrameCount();// 3
		// if given locater has present on webpage, then the element size would be '1'
		// else '0'
		elementpresenceCount = driver.findElements(locator).size();// 0
		while (elementpresenceCount == 0 && loop < maxFramecount) {
			try {
				switchToFrameByInt(loop);
				elementpresenceCount = driver.findElements(locator).size();// 1
				System.out.println("Try LoopAllframesAndReturnWebEL : " + loop + "; ElementpresenceCount: "
						+ elementpresenceCount);
				if (elementpresenceCount > 0 || loop > maxFramecount) {
					break;
				}
			} catch (Exception ex) {
				System.out.println("Catch LoopAllframesAndReturnWebEL Old: " + loop + "; " + ex);
			}
			loop++;
		}
		return elementpresenceCount;
	}

	
	public void excelPath (String excelPath) {
		
		try {
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
	
	public int getRowCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		return rowCount;

	}

	public String getStringData(String sheetName, int Row, int Column) {
		sheet = workbook.getSheet(sheetName);
		String data = sheet.getRow(Row).getCell(Column).getStringCellValue();
		return data;

	}

	public double getNumericData(String sheetName, int Row, int Column) {
		sheet = workbook.getSheet(sheetName);
		double data = sheet.getRow(Row).getCell(Column).getNumericCellValue();
		return data;

	}

	public void setcellData(String sheetName, int Row, int Column, String Result, String excelPath) throws IOException {
		sheet = workbook.getSheet(sheetName);
		sheet.getRow(Row).createCell(Column).setCellValue(Result);

		FileOutputStream fos = new FileOutputStream(excelPath);
		workbook.write(fos);
		fos.close();

	}

}
