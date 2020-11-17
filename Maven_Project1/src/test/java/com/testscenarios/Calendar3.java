package com.testscenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar3 {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.redbus.in");
		driver.manage().window().maximize();
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		Thread.sleep(2000);
		
		//Static way to select date
//		driver.findElement(By.xpath("//table[@class = 'rb-monthTable first last']/tbody/tr[6]/td[3]")).click();
//		Thread.sleep(2000);
		
		//Dynamic way to select date
		List <WebElement> data = driver.findElements(By.xpath("//table[@class = 'rb-monthTable first last']//tbody/tr/td"));
		int totalnodes = data.size();
				
		for (int i=0; i<totalnodes; i++) {
			String date = data.get(i).getText();
								
			if (date.equalsIgnoreCase("20")) {
				data.get(i).click();
				break;
			}
		}
	
	}
}
