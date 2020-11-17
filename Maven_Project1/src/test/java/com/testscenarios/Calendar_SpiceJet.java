package com.testscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar_SpiceJet {
	
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//input[@id = 'ctl00_mainContent_view_date1']")).click();
		Thread.sleep(2000);
		
		//Static way to select the date
//		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[4]")).click();
//		Thread.sleep(3000);
		
		//Dynamic way to select date
		
		List <WebElement> startdates = driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]/tbody/tr/td"));
		int nodecount = startdates.size();
		
		for (int i=0; i<nodecount; i++) {
			String date = startdates.get(i).getText();
			if (date.equalsIgnoreCase("18")) {
				startdates.get(i).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@id = 'ctl00_mainContent_view_date2']")).click();
		Thread.sleep(2000);
		
		List <WebElement> enddates = driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[2]/tbody/tr/td"));
		int nodecount1 = enddates.size();
		
		for (int i=0; i<nodecount1; i++) {
			String date1 = enddates.get(i).getText();
			if (date1.equalsIgnoreCase("25")) {
				enddates.get(i).click();
				break;
			}
		}
		
  }
}
