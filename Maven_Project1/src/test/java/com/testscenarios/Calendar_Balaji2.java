package com.testscenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar_Balaji2 {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://tirupatibalaji.ap.gov.in/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Sign Up")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement mobile = driver.findElement(By.id("indiMobile"));
		mobile.sendKeys("8012344567");
		mobile.sendKeys(Keys.TAB);
		Thread.sleep(4000);
		
		WebElement month = driver.findElement(By.xpath("//select[@title='Change the month']"));
		Select month_dd = new Select (month);
		month_dd.selectByVisibleText("December");
		
		WebElement year = driver.findElement(By.xpath("//select[@title='Change the year']"));
		Select year_dd = new Select (year);
		year_dd.selectByVisibleText("1983");
		
		//Static way to select date
//		driver.findElement(By.xpath("//div[@class = 'datepick-popup']//table/tbody/tr[5]/td[1]")).click();
//		Thread.sleep(3000);
		
		//Dynamic way to select date
		List <WebElement> dates = driver.findElements(By.xpath("//div[@class = 'datepick-popup']//table/tbody/tr/td"));
		int nodecount = dates.size();
		
		for (int i=0; i<nodecount; i++) {
			String date = dates.get(i).getText();
			if (date.equalsIgnoreCase("25")) {
				dates.get(i).click();
				break;
			}
		}
	}
}
