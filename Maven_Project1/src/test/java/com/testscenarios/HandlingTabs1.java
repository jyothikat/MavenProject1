package com.testscenarios;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingTabs1 {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("The title of the main window: " + driver.getTitle());
		
		driver.findElement(By.xpath("//*[contains(text(),'Open New Tabbed Windows')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class='btn btn-info'])[1]")).click();
		
		String parent = driver.getWindowHandle();
		
		Set <String> allwindowIds =  driver.getWindowHandles();
		
		for (String allwindows: allwindowIds) {
			if (!parent.equals(allwindows)) {
				driver.switchTo().window(allwindows);
				Thread.sleep(2000);
				driver.findElement(By.linkText("Downloads")).click();
				Thread.sleep(2000);
				driver.close();
				
			}
		}
		
		driver.switchTo().window(parent);
		System.out.println("Parent window title is "+driver.getTitle());
		driver.quit();
	}
}
