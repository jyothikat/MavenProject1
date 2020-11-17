package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

public class ShearCircle_Scroll extends StaticVariables{
	
	Locators obj = new Locators();
	CommonFunctions cfn = new CommonFunctions();
		
	@BeforeClass
	public void setup() {
		cfn.chromeBrowserLaunch();
		
	}
	
	
  @Test
  public void scroll() throws IOException, InterruptedException {
	 FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
	 Properties prop = new Properties();
	 prop.load(path);
	 
	 driver.get(prop.getProperty("Shearcircle"));
	 driver.manage().window().maximize();
	 Thread.sleep(8000);
	 cfn.clickByAnyLocator(obj.REGISTER);
	 Thread.sleep(8000);
	 System.out.println(driver.getCurrentUrl());

	 WebElement element = driver.findElement(obj.BUSINESSNAME_INPUT);
//	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	 cfn.scrollToElement(element);
	 Thread.sleep(6000);
	 cfn.sendKeysByAnyLocator(obj.BUSINESSNAME_INPUT, prop.getProperty("Businessname"));
	 Thread.sleep(6000);
	 
	 
  }
  
//  @AfterClass
  public void close() {
	  driver.quit();
  }
  
  }
