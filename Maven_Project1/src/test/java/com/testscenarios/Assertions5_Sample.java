package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions5_Sample {
	
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://www.facebook.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(4000);
	  
	  WebElement email = driver.findElement(By.id("email"));
	  Assert.assertTrue(email.isDisplayed(), "The email field is not displayed, please raise a bug");
	  Assert.assertTrue(email.isEnabled(), "The email field is not enabled, please log an issue");
	  email.sendKeys("test@gmail.com");
	  
	  WebElement password = driver.findElement(By.id("pass"));
	  Assert.assertTrue(password.isDisplayed(), "The password field is not displayed, please raise a bug");
	  Assert.assertTrue(password.isEnabled(), "The password field is not enabled, please log an issue");
	  password.sendKeys("test@1");
	  
	  WebElement login = driver.findElement(By.name("login"));
	  Assert.assertTrue(login.isEnabled(), "The login button is disabled, please raise a bug");
	  login.click();
	  
	  String actualtext = driver.getTitle();
	  Assert.assertEquals(actualtext, "Facebook - Log In or Sign Up");
	 
	  
	   
	  
  }
}
