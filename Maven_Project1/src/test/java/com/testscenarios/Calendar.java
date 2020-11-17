package com.testscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.expedia.com");
		driver.manage().window().maximize();
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//span[text()='Flights']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//div[@class='uitk-field has-floatedLabel-label has-icon'])[1]")).click();
		Thread.sleep(8000);
		
		//Static way to select date
//		driver.findElement(By.xpath("(//div[@class='uitk-new-date-picker-month'])[1]//table/tbody/tr[4]/td[4]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//div[@class='uitk-new-date-picker-month'])[2]//table/tbody/tr[3]/td[6]")).click();
//		Thread.sleep(2000);

//		//Dynamic way to select date
		List <WebElement> dates = driver.findElements(By.xpath("(//div[@class='uitk-new-date-picker-month'])[1]//table/tbody/tr/td"));
		int nodecount = dates.size();
		System.out.println(nodecount);
		
		for (int i=0; i<nodecount; i++) {
			
			String startdate = dates.get(i).getText();
			System.out.println(startdate);
			if (startdate.equalsIgnoreCase("25")) {
				dates.get(i).click();
				Thread.sleep(3000);
								
			}
			
			driver.findElement(By.xpath("//span[text()='Done']")).click();
		}
		
		
	}
}
