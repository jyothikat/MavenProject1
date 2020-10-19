package com.testscenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest extends StaticVariables{
	
	CommonFunctions cfn = new CommonFunctions();
	
   
	  @Test
	  public void scrolling() throws InterruptedException {
		  
		  cfn.chromeBrowserLaunch();
		  
		  driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		  driver.manage().window().maximize();
		  Thread.sleep(6000);
		   JavascriptExecutor je = ((JavascriptExecutor)driver);
		  //WebElement element = driver.findElement(By.xpath("(//span[contains(@class,'book-title')])[1]"));
		  WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[3]/div[1]/div[1]/p[3]")); 
		  
		  je.executeAsyncScript("arguments[0].scrollIntoView(true);",element);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		  ((JavascriptExecutor)driver).executeAsyncScript("arguments[0].click();",element);
		  
		  System.out.println(element.getText());
	  }
	  
	  
  }

