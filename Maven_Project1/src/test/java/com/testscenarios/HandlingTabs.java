package com.testscenarios;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingTabs {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		String parent = driver.getWindowHandle();
		System.out.println("Parent window id is : "+parent);
		
		driver.findElement(By.xpath("//a[contains(@href,'http://www.google.com')]")).click();
		Thread.sleep(2000);
		Set <String> allWindowIds = driver.getWindowHandles();
		
		for (String allWindows: allWindowIds) {
			if (!parent.equals(allWindows)) {
				driver.switchTo().window(allWindows);
				driver.findElement(By.name("q")).sendKeys("Selenium");
				Thread.sleep(3000);
				driver.close();
			}
		}
		
		driver.switchTo().window(parent);
		System.out.println("Parent window title is "+driver.getTitle());
		driver.quit();
		
	}
}
