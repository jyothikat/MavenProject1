package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
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
import org.testng.annotations.AfterClass;

public class Justrechargeit_login extends StaticVariables {

	Locators obj = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@Parameters({ "browsername" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {
			cfn.chromeBrowserLaunch();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			cfn.firefoxBrowserLaunch();
		} else if (browsername.equalsIgnoreCase("ie")) {
			cfn.ieBrowserLaunch();
		} else {
			System.out.println("Please enter the browser name within Chrome, Firefox and IE");
		}
	}

	@Test
	public void TC_001() throws IOException, InterruptedException {

		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		driver.get(prop.getProperty("Justcharge"));
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		cfn.implicitWait(20);
		cfn.sendKeysByAnyLocator(obj.EMAIL_INPUT, prop.getProperty("Email"));
		cfn.sendKeysByAnyLocator(obj.PASSWORD2_INPUT, prop.getProperty("Password"));
		cfn.clickByAnyLocator(obj.SECURESIGNIN_BUTTON);
		Thread.sleep(3000);

	}
	
	@Test
	public void TC_002() throws IOException, InterruptedException {
		
		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);
		
		driver.get(prop.getProperty("Facebook"));
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		cfn.implicitWait(20);
		cfn.sendKeysByAnyLocator(obj.FB_EMAIL_INPUT, prop.getProperty("FB_Email"));
		cfn.sendKeysByAnyLocator(obj.FB_PASSWORD_INPUT, prop.getProperty("FB_Password"));
		Thread.sleep(6000);
		cfn.clickByAnyLocator(obj.FB_LOGIN_BUTTON);
		Thread.sleep(16000);
		
	}
	
	
	@AfterClass
	
	public void afterClass() {
		driver.quit();
	}

	@AfterMethod
	public void takeScreenshot() throws IOException {

		cfn.takescreenshotWithTimestamp("Justchargeit");
	}

}
