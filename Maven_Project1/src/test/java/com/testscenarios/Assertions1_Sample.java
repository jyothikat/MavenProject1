package com.testscenarios;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions1_Sample {
	
	WebDriver driver;
	
  @Test
  public void testcase1() {
	  
	  Assert.assertEquals(12, 12);
  }
  
  @Test
  public void validatePageTitle() {
	  
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 
	 driver.get("https://www.facebook.com");
	 driver.manage().window().maximize();
	 
	 String actualtitle = driver.getTitle();
	 String expectedtitle = "Facebook - Log In or Sign Up";
	 
	 Assert.assertEquals(actualtitle, expectedtitle);
	 
	 
	 
  }
  
}
