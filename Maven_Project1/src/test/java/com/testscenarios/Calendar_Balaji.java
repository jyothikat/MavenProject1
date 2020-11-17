package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar_Balaji extends StaticVariables{

	
	CommonFunctions cfn = new CommonFunctions();
	Locators obj = new Locators();

	@Test
	public void f() throws InterruptedException, IOException {
		
		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://tirupatibalaji.ap.gov.in/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Sign Up")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement mobile = driver.findElement(By.id("indiMobile"));
		mobile.sendKeys("8012344567");
		mobile.sendKeys(Keys.TAB);
		Thread.sleep(6000);
		
		cfn.selectByVisibleText(obj.TTDMONTH_DROPDOWN, prop.getProperty("MONTH"));
		Thread.sleep(8000);
				
		cfn.selectByVisibleText(obj.TTDYEAR_DROPDOWN, prop.getProperty("YEAR"));
		Thread.sleep(6000);
		
		cfn.clickByAnyLocator(obj.TTDDATE_TABLE);
		Thread.sleep(6000);
	}
}
