package com.testscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar4 {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.redbus.com");
		driver.manage().window().maximize();
		Thread.sleep(6000);

		// Select from
		driver.findElement(By.xpath("//input[@id = 'src']")).sendKeys("Hyderabad");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Hyderabad Airport, Andhra Pradesh, India']")).click();
		Thread.sleep(2000);

		// Select arrival
		driver.findElement(By.xpath("//input[@id = 'dest']")).sendKeys("Bangalore");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text() = 'Bangalore Intl Airport, Karnataka, India']")).click();
		Thread.sleep(2000);

		// Start date
		driver.findElement(By.xpath("//span[@class = 'fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		Thread.sleep(2000);

		// Static way to select start date
//		driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[7]/td[1]")).click();
//		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id = 'rb-calendar_onward_cal']/table/tbody/tr[1]/td[3]")).click();
		Thread.sleep(3000);

		// Dynamic way to select start date
		List<WebElement> dates = driver
				.findElements(By.xpath("//div[@id = 'rb-calendar_onward_cal']/table/tbody/tr/td"));
		int nodecount = dates.size();
		
		for (WebElement webElement : dates) {
			
			String date = webElement.getText();
			if (date.equalsIgnoreCase("23")) {
				webElement.click();
				break;
			}
		}

//		for (int i = 0; i < nodecount; i++) {
//			String startdate = dates.get(i).getText();
//
//			if (startdate.equalsIgnoreCase("23")) {
//				dates.get(i).click();
//				break;
//			}
//
//		}

		// End date
		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-return-calendar icon']")).click();
		Thread.sleep(2000);

		// Static way to select end date
//		driver.findElement(By.xpath("//div[@id='rb-calendar_return_cal']/table/tbody/tr[7]/td[7]")).click();
//		Thread.sleep(2000);

		// Dynamic way to select end date
		List<WebElement> dates2 = driver
				.findElements(By.xpath("//div[@id='rb-calendar_return_cal']/table/tbody/tr/td"));
		int nodecount2 = dates2.size();

		for (int i = 0; i < nodecount2; i++) {
			String enddate = dates2.get(i).getText();

			if (enddate.equalsIgnoreCase("28")) {
				dates2.get(i).click();
				break;
			}

		}

		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(6000);
	}
}
