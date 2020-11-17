package com.testscenarios;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingTabs3 {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(@href,'http://www.google.com')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//a[contains(@href,'http://www.facebook.com')])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[contains(@href,'http://www.yahoo.com')]")).click();
		Thread.sleep(6000);
		
		String parent = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("The no. of tabs are " + allWindows.size());

		ArrayList<String> tabs = new ArrayList<String>(allWindows);

		// Switch to Google tab
		driver.switchTo().window(tabs.get(3));
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(2000);
		driver.close();

		// Switch to facebook tab
		driver.switchTo().window(tabs.get(2));
		driver.findElement(By.name("email")).sendKeys("jyokatragadda@gmail.com");
		Thread.sleep(2000);
		driver.close();

		// Switch to yahoo tab
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.name("p")).sendKeys("testing");
		Thread.sleep(2000);
		driver.close();
		
		driver.switchTo().window(tabs.get(0));
		System.out.println("The parent window title is "+driver.getTitle());
		driver.quit();
	}
}
