package com.testscenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar_Redbus {
	
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 
	 driver.get("https://www.redbus.in");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	 driver.findElement(By.xpath("//div[@class='fl search-box date-box gtm-onwardCalendar']")).click();
	 Thread.sleep(3000);
	 
	 //Static way to pick the date
//	 driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr[6]/td[3]")).click();
//	 Thread.sleep(3000);
	 
	 //Dynamic way to select the date
	 List <WebElement> dates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td"));
	 int totalnodes = dates.size();
	 
	 for (int i = 0; i < totalnodes; i++) {
		 String date = dates.get(i).getText();
		 
		 if (date.equalsIgnoreCase("18")) {
			 dates.get(i).click();
			 break;
		 }
		 
	 }
  }
  
}
