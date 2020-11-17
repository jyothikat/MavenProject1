package com.testscenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Balaji_login extends StaticVariables {

	// Create Locators class object and use that object to call the locators
	Locators obj = new Locators();

	CommonFunctions cfn = new CommonFunctions();

	@Parameters({ "browsername" })
	@BeforeClass
	public void setup(@Optional("ie") String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			cfn.chromeBrowserLaunch();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			cfn.firefoxBrowserLaunch();
		} else if (browsername.equalsIgnoreCase("ie")) {
			cfn.ieBrowserLaunch();
		} else {
			System.out.println("Please enter the browsername between Chrome, Firefox and IE");
		}

	}

	@Test(priority = 1)
	public void TC_001() throws InterruptedException, IOException {

		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		// Launch the URL
		driver.get(prop.getProperty("Balaji"));
		driver.manage().window().maximize();
		Thread.sleep(6000);
//		WebElement signup = driver.findElement(obj.SIGNUP_LINK);
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", signup);
		cfn.clickByAnyLocatorJavascript(obj.SIGNUP_LINK);

		Thread.sleep(6000);
//		driver.findElement(obj.FIRSTNAME_INPUT).sendKeys(prop.getProperty("Firstname"));
		cfn.sendKeysByAnyLocator(obj.FIRSTNAME_INPUT, prop.getProperty("Firstname"));
//		driver.findElement(obj.LASTNAME_INPUT).sendKeys(prop.getProperty("Lastname"));
		cfn.sendKeysByAnyLocator(obj.LASTNAME_INPUT, prop.getProperty("Lastname"));
//		driver.findElement(obj.MOBILENUMBER_INPUT).sendKeys(prop.getProperty("Mobilenumber"));
		cfn.sendKeysByAnyLocator(obj.MOBILENUMBER_INPUT, prop.getProperty("Mobilenumber"));
		Thread.sleep(6000);

		WebElement gender = driver.findElement(obj.GENDER_RADIO);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", gender);

//		driver.findElement(obj.ADDRESSLINE1_INPUT).sendKeys(prop.getProperty("Addressline1"));
		cfn.sendKeysByAnyLocator(obj.ADDRESSLINE1_INPUT, prop.getProperty("Addressline1"));
//		driver.findElement(obj.ADDRESSLINE2_INPUT).sendKeys(prop.getProperty("Addressline2"));
		cfn.sendKeysByAnyLocator(obj.ADDRESSLINE2_INPUT, prop.getProperty("Addressline2"));
//		driver.findElement(obj.CITY_INPUT).sendKeys(prop.getProperty("City"));
		cfn.sendKeysByAnyLocator(obj.CITY_INPUT, prop.getProperty("City"));
		
		cfn.selectByVisibleText(obj.COUNTRY_DROPDOWN, prop.getProperty("Country"));
//		Select country = new Select(driver.findElement(obj.COUNTRY_DROPDOWN));
//		country.selectByVisibleText(prop.getProperty("Country"));
		
		cfn.printAllDropdownValues(obj.COUNTRY_DROPDOWN);
		
		cfn.selectByVisibleText(obj.STATE_DROPDOWN, prop.getProperty("State"));
//		Select state = new Select(driver.findElement(obj.STATE_DROPDOWN));
//		state.selectByVisibleText(prop.getProperty("State"));

//		driver.findElement(obj.ZIPCODE_INPUT).sendKeys(prop.getProperty("Zipcode"));
		cfn.sendKeysByAnyLocator(obj.ZIPCODE_INPUT, prop.getProperty("Zipcode"));
		Select photoid = new Select(driver.findElement(obj.PHOTOIDPROOF_DROPDOWN));
		photoid.selectByVisibleText(prop.getProperty("PhotoID"));

//		driver.findElement(obj.PHOTOIDCARDNUMBER_INPUT).sendKeys(prop.getProperty("PhotoIDcard"));
		cfn.sendKeysByAnyLocator(obj.PHOTOIDCARDNUMBER_INPUT, prop.getProperty("PhotoIDcard"));
//		driver.findElement(obj.USERNAME_INPUT).sendKeys(prop.getProperty("Username"));
		cfn.sendKeysByAnyLocator(obj.USERNAME_INPUT, prop.getProperty("Username"));
//		driver.findElement(obj.PASSWORD_INPUT).sendKeys(prop.getProperty("Password"));
		cfn.sendKeysByAnyLocator(obj.PASSWORD_INPUT, prop.getProperty("Password"));
//		driver.findElement(obj.CONFIRMPASSWORD_INPUT).sendKeys(prop.getProperty("ConfirmPassword"));
		cfn.sendKeysByAnyLocator(obj.CONFIRMPASSWORD_INPUT, prop.getProperty("ConfirmPassword"));
		Thread.sleep(4000);
//		WebElement cont = driver.findElement(obj.CONTINUE_BUTTON);
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cont);
		cfn.clickByAnyLocatorJavascript(obj.CONTINUE_BUTTON);
		Thread.sleep(6000);
	}

	@Test(priority = 0)
	public void TC_002() throws InterruptedException, IOException {

		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		driver.get(prop.getProperty("Google"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
//		driver.findElement(obj.SEARCH_INPUT).sendKeys(prop.getProperty("Searchtext"));
		cfn.sendKeysByAnyLocator(obj.SEARCH_INPUT, prop.getProperty("Searchtext"));
		Thread.sleep(6000);
//		driver.findElement(obj.GOOGLESEARCH_BUTTON).submit();
		cfn.clickByAnyLocator(obj.GOOGLESEARCH_BUTTON);
		Thread.sleep(6000);
	}

	@AfterClass
	public void afterclass() {
		driver.quit();
	}

	@AfterMethod
	public void takeScreenshot() throws IOException {

			cfn.takescreenshotWithTimestamp("Balaji");
		}

	}


