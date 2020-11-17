package com.testscenarios;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  
	  driver.get("https://www.onlinesbi.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("//*[@class='classicTxt']")).click();
	  Thread.sleep(6000);
	  driver.findElement(By.linkText("CONTINUE TO LOGIN")).click();
	  Thread.sleep(6000);
	  driver.findElement(By.xpath("//*[@title='Login']")).click();
	  Thread.sleep(6000);
	  
	  String actual_text = driver.switchTo().alert().getText();
	  System.out.println("The alert message is "+actual_text);
	  
	  String expected_text = "Enter username";
	  
	  if (expected_text.equalsIgnoreCase(actual_text)) {
		  System.out.println("The test passed");
	  }
	  else {
		  System.out.println("The test failed");
	  }
	  
	  	  
//	  assertEquals(actual_text, expected_text);
	  	  
	  driver.findElement(By.partialLinkText("New User ? Register here/Activate")).click();
	  Thread.sleep(6000);
	  driver.switchTo().alert().dismiss();
	  driver.quit();
	  
  }
}
