package com.testscenarios;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class DataProviderSample {

	WebDriver driver;
	
	@Parameters ("browsername")
	@BeforeClass
	public void setup(@Optional ("chrome") String browsername) {
		
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		} else if (browsername.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Please enter the browser name within Chrome, Firefox or Edge");
		}
		
	}

	@Test(dataProvider = "dp")
	public void f(String UserName, String Password) throws InterruptedException {

		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys(UserName);
		driver.findElement(By.id("pass")).sendKeys(Password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(8000);

	}
	
	@DataProvider
	public Object[][] dp() {
		return new Object[][] { 
			new Object[] { "test1@gmail.com", "test@1" },
			new Object[] { "test2@gmail.com", "test@2" }, 
			new Object[] { "test3@gmail.com", "test@3" },
			new Object[] { "test4@gmail.com", "test@4" },

		};
	}
}
